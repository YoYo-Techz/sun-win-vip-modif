package bitzero.server.entities;

import bitzero.engine.sessions.ISession;
import bitzero.server.entities.managers.BZUserManager;
import bitzero.server.entities.managers.IUserManager;
import bitzero.server.exceptions.BZErrorCode;
import bitzero.server.exceptions.BZErrorData;
import bitzero.server.exceptions.BZJoinRoomException;
import bitzero.server.exceptions.BZRoomException;
import bitzero.server.extensions.IBZExtension;
import bitzero.server.util.IPlayerIdGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Room {
     private static AtomicInteger autoID = new AtomicInteger(0);
     private int id;
     private String groupId;
     private String name;
     private String password;
     private boolean passwordProtected;
     private int maxUsers;
     private int maxSpectators;
     private int moneyBet;
     private User owner;
     private IUserManager userManager;
     private Zone zone;
     private volatile IBZExtension extension;
     private boolean dynamic;
     private boolean game;
     private boolean hidden;
     private volatile boolean active;
     private BZRoomRemoveMode autoRemoveMode;
     private IPlayerIdGenerator playerIdGenerator;
     private final Lock switchUserLock;
     private final Map properties;
     private Set flags;
     protected Logger logger;
     private boolean isGameFlagInited;

     private static int getNewID() {
          return autoID.getAndIncrement();
     }

     public Room(String name) {
          this(name, (Class)null);
     }

     public Room(String name, Class customPlayerIdGeneratorClass) {
          this.isGameFlagInited = false;
          this.id = getNewID();
          this.name = name;
          this.active = false;
          this.logger = LoggerFactory.getLogger(this.getClass());
          this.properties = new ConcurrentHashMap();
          this.userManager = new BZUserManager();
          this.switchUserLock = new ReentrantLock();
     }

     public int getId() {
          return this.id;
     }

     public String getGroupId() {
          return this.groupId != null && this.groupId.length() > 0 ? this.groupId : "default";
     }

     public void setGroupId(String groupId) {
          this.groupId = groupId;
     }

     public String getName() {
          return this.name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getPassword() {
          return this.password;
     }

     public void setPassword(String password) {
          this.password = password;
          if (this.password != null && this.password.length() > 0) {
               this.passwordProtected = true;
          } else {
               this.passwordProtected = false;
          }

     }

     public boolean isPasswordProtected() {
          return this.passwordProtected;
     }

     public boolean isPublic() {
          return !this.passwordProtected;
     }

     public int getMaxUsers() {
          return this.maxUsers;
     }

     public void setMaxUsers(int maxUsers) {
          this.maxUsers = maxUsers;
          if (this.isGame() && this.playerIdGenerator != null) {
               this.playerIdGenerator.onRoomResize();
          }

     }

     public int getMaxSpectators() {
          return this.maxSpectators;
     }

     public void setMaxSpectators(int maxSpectators) {
          this.maxSpectators = maxSpectators;
     }

     public User getOwner() {
          return this.owner;
     }

     public void setOwner(User owner) {
          this.owner = owner;
     }

     public IUserManager getUserManager() {
          return this.userManager;
     }

     public void setUserManager(IUserManager userManager) {
          this.userManager = userManager;
     }

     public Zone getZone() {
          return this.zone;
     }

     public void setZone(Zone zone) {
          this.zone = zone;
          this.instantiateRoomIdGenerator();
     }

     public boolean isDynamic() {
          return this.dynamic;
     }

     public void setDynamic(boolean dynamic) {
          this.dynamic = dynamic;
     }

     public boolean isGame() {
          return this.game;
     }

     public void setGame(boolean game, Class customPlayerIdGeneratorClass) {
          if (this.isGameFlagInited) {
               throw new IllegalStateException(this.toString() + ", isGame flag cannot be reset");
          } else {
               this.game = game;
               this.isGameFlagInited = true;
               if (this.game) {
                    try {
                         this.playerIdGenerator = (IPlayerIdGenerator)customPlayerIdGeneratorClass.newInstance();
                         this.playerIdGenerator.setParentRoom(this);
                         this.playerIdGenerator.init();
                    } catch (InstantiationException var4) {
                         this.logger.warn(String.format("Cannot instantiate Player ID Generator: %s, Reason: %s -- Room might not function correctly.", customPlayerIdGeneratorClass, var4));
                    } catch (IllegalAccessException var5) {
                         this.logger.warn(String.format("Illegal Access to Player ID Generator Class: %s, Reason: %s -- Room might not function correctly.", customPlayerIdGeneratorClass, var5));
                    }
               }

          }
     }

     public void setGame(boolean game) {
          this.setGame(game, (Class)null);
     }

     public boolean isHidden() {
          return this.hidden;
     }

     public void setHidden(boolean hidden) {
          this.hidden = hidden;
     }

     public synchronized boolean isActive() {
          return this.active;
     }

     public synchronized void setActive(boolean flag) {
          this.active = flag;
     }

     public BZRoomRemoveMode getAutoRemoveMode() {
          return this.autoRemoveMode;
     }

     public void setAutoRemoveMode(BZRoomRemoveMode autoRemoveMode) {
          this.autoRemoveMode = autoRemoveMode;
     }

     public List getPlayersList() {
          List playerList = new ArrayList();
          Iterator iterator = this.userManager.getAllUsers().iterator();

          while(iterator.hasNext()) {
               User user = (User)iterator.next();
               if (user.isPlayer()) {
                    playerList.add(user);
               }
          }

          return playerList;
     }

     public Object getProperty(Object key) {
          return this.properties.get(key);
     }

     public RoomSize getSize() {
          int uCount = 0;
          int sCount = 0;
          if (this.game) {
               Iterator iterator = this.userManager.getAllUsers().iterator();

               while(iterator.hasNext()) {
                    User user = (User)iterator.next();
                    if (user.isPlayer()) {
                         ++uCount;
                    } else {
                         ++sCount;
                    }
               }
          } else {
               uCount = this.userManager.getUserCount();
          }

          return new RoomSize(uCount, sCount);
     }

     public void removeProperty(Object key) {
          this.properties.remove(key);
     }

     public List getSpectatorsList() {
          List specList = new ArrayList();
          Iterator iterator = this.userManager.getAllUsers().iterator();

          while(iterator.hasNext()) {
               User user = (User)iterator.next();
               if (user.isSpectator()) {
                    specList.add(user);
               }
          }

          return specList;
     }

     public User getUserById(int id) {
          return this.userManager.getUserById(id);
     }

     public List getUserByName(String name) {
          return this.userManager.getUserByName(name);
     }

     public User getUserBySession(ISession session) {
          return this.userManager.getUserBySession(session);
     }

     public User getUserByPlayerId(int playerId) {
          User user = null;
          Iterator iterator = this.userManager.getAllUsers().iterator();

          while(iterator.hasNext()) {
               User u = (User)iterator.next();
               if (u.getPlayerId() == playerId) {
                    user = u;
                    break;
               }
          }

          return user;
     }

     public List getUserList() {
          return this.userManager.getAllUsers();
     }

     public List getSessionList() {
          return this.userManager.getAllSessions();
     }

     public boolean containsProperty(Object key) {
          return this.properties.containsKey(key);
     }

     public int getCapacity() {
          return this.maxUsers + this.maxSpectators;
     }

     public void setCapacity(int maxUser, int maxSpectators) {
          this.maxUsers = maxUser;
          this.maxSpectators = maxSpectators;
     }

     public void setFlags(Set settings) {
          this.flags = settings;
     }

     public void setProperty(Object key, Object value) {
          this.properties.put(key, value);
     }

     public boolean containsUser(String name) {
          return this.userManager.getUserByName(name) != null;
     }

     public boolean containsUser(User user) {
          return this.userManager.containsUser(user);
     }

     public void addUser(User user, boolean asSpectator, int targetPlayerId, boolean isHolding) throws BZJoinRoomException {
          if (this.userManager.containsId(user.getUniqueId()) && !isHolding) {
               String message = String.format("User already joined: %s, Room: %s, Zone: %s", user, this, this.getZone());
               BZErrorData data = new BZErrorData(BZErrorCode.JOIN_ALREADY_JOINED);
               data.addParameter(this.name);
               throw new BZJoinRoomException(message, data);
          } else {
               boolean okToAdd = false;
               synchronized(this) {
                    RoomSize roomSize = this.getSize();
                    if (this.isGame() && asSpectator) {
                         okToAdd = roomSize.getSpectatorCount() < this.maxSpectators;
                    } else {
                         okToAdd = roomSize.getUserCount() < this.maxUsers || isHolding;
                    }

                    String message;
                    BZErrorData data;
                    if (!okToAdd) {
                         message = String.format("Room is full: %s, Zone: %s - Can't add User: %s ", this.name, this.zone, user);
                         data = new BZErrorData(BZErrorCode.JOIN_ROOM_FULL);
                         data.addParameter(this.name);
                         throw new BZJoinRoomException(message, data);
                    } else {
                         this.userManager.addUser(user);
                         if (this.isGame()) {
                              if (asSpectator) {
                                   user.setPlayerId(-1, this);
                              } else if (targetPlayerId <= 0) {
                                   user.setPlayerId(this.playerIdGenerator.getPlayerSlot(), this);
                              } else {
                                   if (!this.playerIdGenerator.takeSlot(targetPlayerId)) {
                                        this.userManager.removeUser(user);
                                        message = String.format("Cannot Add User to Char: %s, Zone: %s - Can't add User: %s , Chair: %d", this.name, this.zone, user, targetPlayerId);
                                        data = new BZErrorData(BZErrorCode.JOIN_ROOM_FULL);
                                        data.addParameter(this.name);
                                        throw new BZJoinRoomException(message, data);
                                   }

                                   user.setPlayerId(targetPlayerId, this);
                              }
                         } else {
                              user.setPlayerId(0, this);
                         }

                    }
               }
          }
     }

     public void addUser(User user, boolean asSpectator, int targetPlayerId) throws BZJoinRoomException {
          this.addUser(user, asSpectator, targetPlayerId, false);
     }

     public void addUser(User user) throws BZJoinRoomException {
          this.addUser(user, false);
     }

     public void addUser(User user, boolean asSpectator) throws BZJoinRoomException {
          if (this.userManager.containsId(user.getUniqueId())) {
               String message = String.format("User already joined: %s, Room: %s, Zone: %s", user, this, this.getZone());
               BZErrorData data = new BZErrorData(BZErrorCode.JOIN_ALREADY_JOINED);
               data.addParameter(this.name);
               throw new BZJoinRoomException(message, data);
          } else {
               boolean okToAdd = false;
               synchronized(this) {
                    RoomSize roomSize = this.getSize();
                    if (this.isGame() && asSpectator) {
                         okToAdd = roomSize.getSpectatorCount() < this.maxSpectators;
                    } else {
                         okToAdd = roomSize.getUserCount() < this.maxUsers;
                    }

                    if (!okToAdd) {
                         String message = String.format("Room is full: %s, Zone: %s - Can't add User: %s ", this.name, this.zone, user);
                         BZErrorData data = new BZErrorData(BZErrorCode.JOIN_ROOM_FULL);
                         data.addParameter(this.name);
                         throw new BZJoinRoomException(message, data);
                    } else {
                         this.userManager.addUser(user);
                         if (this.isGame()) {
                              if (asSpectator) {
                                   user.setPlayerId(-1, this);
                              } else {
                                   user.setPlayerId(this.playerIdGenerator.getPlayerSlot(), this);
                              }
                         } else {
                              user.setPlayerId(0, this);
                         }

                    }
               }
          }
     }

     public void removeUser(User user) {
          if (this.isGame()) {
               this.playerIdGenerator.freePlayerSlot(user.getPlayerId());
          }

          this.userManager.removeUser(user);
          user.removeJoinedRoom(this);
     }

     public void switchPlayerToSpectator(User user) throws BZRoomException {
          BZErrorData errData;
          if (!this.isGame()) {
               errData = new BZErrorData(BZErrorCode.SWITCH_NOT_A_GAME_ROOM);
               errData.addParameter(this.name);
               throw new BZRoomException("Not supported in a non-game room", errData);
          } else if (!this.userManager.containsUser(user)) {
               errData = new BZErrorData(BZErrorCode.SWITCH_NOT_JOINED_IN_ROOM);
               errData.addParameter(this.name);
               throw new BZRoomException(String.format("%s is not joined in %s", user, this));
          } else {
               this.switchUserLock.lock();

               try {
                    if (this.getSize().getSpectatorCount() >= this.maxSpectators) {
                         errData = new BZErrorData(BZErrorCode.SWITCH_NO_SPECTATOR_SLOTS_AVAILABLE);
                         errData.addParameter(this.name);
                         throw new BZRoomException("All Spectators slots are already occupied!", errData);
                    }

                    int currentPlayerId = user.getPlayerId();
                    user.setPlayerId(-1, this);
                    this.playerIdGenerator.freePlayerSlot(currentPlayerId);
               } finally {
                    this.switchUserLock.unlock();
               }

          }
     }

     public void switchSpectatorToPlayer(User user, int targetPlayerId) throws BZRoomException {
          BZErrorData errData;
          if (!this.isGame()) {
               errData = new BZErrorData(BZErrorCode.SWITCH_NOT_A_GAME_ROOM);
               errData.addParameter(this.name);
               throw new BZRoomException("Not supported in a non-game room", errData);
          } else if (!this.userManager.containsUser(user)) {
               errData = new BZErrorData(BZErrorCode.SWITCH_NOT_JOINED_IN_ROOM);
               errData.addParameter(this.name);
               throw new BZRoomException(String.format("%s is not joined in %s", user, this));
          } else {
               this.switchUserLock.lock();

               try {
                    if (this.getSize().getUserCount() >= this.maxUsers) {
                         errData = new BZErrorData(BZErrorCode.SWITCH_NO_PLAYER_SLOTS_AVAILABLE);
                         errData.addParameter(this.name);
                         throw new BZRoomException("All Player slots are already occupied!", errData);
                    }

                    if (targetPlayerId <= 0) {
                         user.setPlayerId(this.playerIdGenerator.getPlayerSlot(), this);
                    } else {
                         if (!this.playerIdGenerator.takeSlot(targetPlayerId)) {
                              errData = new BZErrorData(BZErrorCode.SWITCH_NO_PLAYER_SLOTS_AVAILABLE);
                              errData.addParameter(this.name);
                              throw new BZRoomException("Bad parameter or Player slot are already occupied!", errData);
                         }

                         user.setPlayerId(targetPlayerId, this);
                    }
               } finally {
                    this.switchUserLock.unlock();
               }

          }
     }

     public void switchSpectatorToPlayer(User user) throws BZRoomException {
          this.switchSpectatorToPlayer(user, 0);
     }

     public boolean isEmpty() {
          return this.userManager.getUserCount() == 0;
     }

     public boolean isFull() {
          if (this.isGame()) {
               return this.getSize().getUserCount() == this.maxUsers;
          } else {
               return this.userManager.getUserCount() == this.maxUsers;
          }
     }

     public String toString() {
          return String.format("[ Room: %s, Id: %s, Group: %s, isGame: %s ]", this.name, this.id, this.groupId, this.game);
     }

     public boolean equals(Object obj) {
          if (!(obj instanceof Room)) {
               return false;
          } else {
               Room room = (Room)obj;
               boolean isEqual = false;
               if (room.getId() == this.id) {
                    isEqual = true;
               }

               return isEqual;
          }
     }

     public IBZExtension getExtension() {
          return this.extension;
     }

     public void setExtension(IBZExtension extension) {
          this.extension = extension;
     }

     public String getDump() {
          StringBuilder sb = (new StringBuilder("/////////////// Room Dump ////////////////")).append("\n");
          sb.append("\tName: ").append(this.name).append("\n").append("\tId: ").append(this.id).append("\n").append("\tGroupId: ").append(this.groupId).append("\n").append("\tPassword: ").append(this.password).append("\n").append("\tOwner: ").append(this.owner != null ? this.owner.toString() : "[[ SERVER ]]").append("\n").append("\tisDynamic: ").append(this.dynamic).append("\n").append("\tisGame: ").append(this.game).append("\n").append("\tisHidden: ").append(this.hidden).append("\n").append("\tsize: ").append(this.getSize()).append("\n").append("\tMaxUser: ").append(this.maxUsers).append("\n").append("\tMaxSpect: ").append(this.maxSpectators).append("\n").append("\tMaxVars: ").append("\n").append("\tRemoveMode: ").append(this.autoRemoveMode).append("\n").append("\tPlayerIdGen: ").append(this.playerIdGenerator).append("\n").append("\tSettings: ").append("\n");
          if (this.properties.size() > 0) {
               sb.append("\tProperties: ").append("\n");
               Iterator iterator1 = this.properties.keySet().iterator();

               while(iterator1.hasNext()) {
                    Object key = iterator1.next();
                    sb.append("\t\t").append(key).append(": ").append(this.properties.get(key)).append("\n");
               }
          }

          if (this.extension != null) {
               sb.append("\tExtension: ").append("\n");
               sb.append("\t\t").append("Name: ").append(this.extension.getName()).append("\n");
               sb.append("\t\t").append("Class: ").append(this.extension.getExtensionFileName()).append("\n");
               sb.append("\t\t").append("Props: ").append(this.extension.getPropertiesFileName()).append("\n");
          }

          sb.append("/////////////// End Dump /////////////////").append("\n");
          return sb.toString();
     }

     private void instantiateRoomIdGenerator() {
          String className = null;
          if (className == null) {
               className = "bitzero.server.util.DefaultPlayerIdGenerator";
          }

          try {
               Class theClass = Class.forName(className);
               this.playerIdGenerator = (IPlayerIdGenerator)theClass.newInstance();
          } catch (Exception var3) {
               this.logger.error("Could not instantiate the IPlayerIdGenerator object. Room: " + this + ", class: " + className + ", err: " + var3);
          }

     }

     private void populateTransientFields() {
          this.logger = LoggerFactory.getLogger(this.getClass());
          this.extension = null;
     }
}
