package bitzero.engine.exceptions;

public class MessageQueueFullException extends Exception {
     public MessageQueueFullException() {
     }

     public MessageQueueFullException(String message) {
          super(message);
     }
}
