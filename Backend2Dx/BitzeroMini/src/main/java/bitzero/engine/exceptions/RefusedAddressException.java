package bitzero.engine.exceptions;

public class RefusedAddressException extends Exception {
     public RefusedAddressException() {
     }

     public RefusedAddressException(String message) {
          super(message);
     }
}
