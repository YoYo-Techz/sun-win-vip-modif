package bitzero.engine.exceptions;

public class PacketQueueWarning extends RuntimeException {
     public PacketQueueWarning() {
     }

     public PacketQueueWarning(String message) {
          super(message);
     }
}
