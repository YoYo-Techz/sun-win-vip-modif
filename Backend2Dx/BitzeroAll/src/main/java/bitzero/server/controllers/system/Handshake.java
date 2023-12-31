package bitzero.server.controllers.system;

import bitzero.engine.io.IRequest;
import bitzero.engine.io.IResponse;
import bitzero.engine.io.Response;
import bitzero.engine.sessions.ISession;
import bitzero.server.config.DefaultConstants;
import bitzero.server.controllers.BaseControllerCommand;
import bitzero.server.controllers.SystemRequest;
import bitzero.server.controllers.system.cmd.ReceiveHandsake;
import bitzero.server.controllers.system.cmd.SendHandsake;
import bitzero.server.entities.User;
import bitzero.server.entities.data.ISFSObject;
import bitzero.server.entities.data.SFSObject;
import bitzero.server.extensions.data.DataCmd;
import bitzero.server.util.CryptoUtils;
import java.nio.ByteBuffer;

public class Handshake extends BaseControllerCommand {
     public static final String KEY_BIN_FLAG = "bin";
     public static final String KEY_API = "api";
     public static final String KEY_TOKEN = "tk";
     public static final String KEY_COMPRESSION_THRESHOLD = "ct";
     public static final String KEY_RECONNECTION_TOKEN = "rt";
     public static final String KEY_CLIENT_TYPE = "cl";
     public static final String KEY_MAX_MESSAGE_SIZE = "ms";

     public Handshake() {
          super(SystemRequest.Handshake);
     }

     public void execute(IRequest request) throws Exception {
          ISession sender = request.getSender();
          DataCmd params = new DataCmd(((ByteBuffer)request.getContent()).array());
          ReceiveHandsake handSakeCmd = new ReceiveHandsake(params);
          handSakeCmd.unpackData();
          String reconnectionToken = handSakeCmd.sessionToken;
          if (this.isApiVersionOk("")) {
               String sessionToken = null;
               if (reconnectionToken != null && reconnectionToken.length() > 2) {
                    ISession resumedSession = this.bz.getSessionManager().reconnectSession(sender, reconnectionToken);
                    if (resumedSession == null) {
                         return;
                    }

                    sender = resumedSession;
                    sessionToken = resumedSession.getHashId();
                    User user = this.bz.getUserManager().getUserBySession(resumedSession);
                    if (user == null) {
                         this.logger.info("User not found at reconnection time. " + resumedSession);
                    } else {
                         user.updateLastRequestTime();
                         this.logger.info("Reconnected USER: " + user + ", logged: " + resumedSession.isLoggedIn());
                    }
               } else {
                    sessionToken = CryptoUtils.getUniqueSessionToken(sender);
                    sender.setHashId(sessionToken);
                    this.bz.getSessionManager().addSessionToken(sender);
               }

               sender.setSystemProperty("ClientType", "Unknown");
               reconnectionToken = sessionToken;
          }

          SendHandsake msg = new SendHandsake();
          msg.sessionToken = reconnectionToken;
          msg.reconnectTime = this.bz.getConfigurator().getServerSettings().userReconnectionSeconds;
          IResponse response = new Response();
          response.setId(this.getId());
          response.setRecipients(sender);
          response.setContent(msg.createData());
          response.setTargetController(DefaultConstants.CORE_SYSTEM_CONTROLLER_ID);
          response.write();
     }

     public void executeWebsocket(IRequest request) throws Exception {
          ISession sender = request.getSender();
          ISFSObject reqObj = (ISFSObject)request.getContent();
          String apiVersionStr = reqObj.getUtfString("api");
          String reconnectionToken = reqObj.getUtfString("rt");
          ISFSObject resObj = SFSObject.newInstance();
          if (this.isApiVersionOk(apiVersionStr)) {
               String sessionToken = null;
               if (reconnectionToken != null) {
                    ISession resumedSession = this.bz.getSessionManager().reconnectSession(sender, reconnectionToken);
                    if (resumedSession == null) {
                         return;
                    }

                    sender = resumedSession;
                    sessionToken = resumedSession.getHashId();
                    User user = this.bz.getUserManager().getUserBySession(resumedSession);
                    if (user == null) {
                         this.logger.warn("User not found at reconnection time. " + resumedSession);
                    } else {
                         user.updateLastRequestTime();
                         this.logger.info("Reconnected USER: " + user + ", logged: " + resumedSession.isLoggedIn());
                    }
               } else {
                    sessionToken = CryptoUtils.getUniqueSessionToken(sender);
                    this.bz.getSessionManager().addSessionToken(sender);
               }

               sender.setSystemProperty("ClientType", reqObj.containsKey("cl") ? reqObj.getUtfString("cl") : "Unknown");
               sender.setHashId(sessionToken);
               resObj.putUtfString("tk", sessionToken);
               resObj.putInt("ct", this.bz.getConfigurator().getServerSettings().protocolCompressionThreshold);
               resObj.putInt("ms", this.bz.getConfigurator().getCoreSettings().maxIncomingRequestSize);
          }

          IResponse response = new Response();
          response.setId(this.getId());
          response.setRecipients(sender);
          response.setContent(resObj);
          response.setTargetController(DefaultConstants.CORE_SYSTEM_CONTROLLER_ID);
          response.write();
     }

     private String formatVersionNumber(int ver) {
          String unformatted = String.valueOf(ver);
          int additionalZeros = 3 - unformatted.length();
          StringBuffer sb = new StringBuffer();
          int j;
          if (additionalZeros > 0) {
               for(j = 0; j < additionalZeros; ++j) {
                    sb.append('0');
               }
          }

          sb.append(unformatted);
          j = sb.length() - 1;
          sb.insert(j, '.');
          --j;
          sb.insert(j, '.');
          return sb.toString();
     }

     public boolean validate(IRequest request) {
          return true;
     }

     private boolean isApiVersionOk(String apiVersionStr) {
          boolean ok = true;
          return ok;
     }
}
