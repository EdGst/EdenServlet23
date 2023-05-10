package technifutur.be.technifutur.exceptions;

public class InvalidPasswordUserException extends RuntimeException{

    public InvalidPasswordUserException() {
        super("Invalid password");
    }

    public InvalidPasswordUserException(String message) {
        super(message);
    }
}
