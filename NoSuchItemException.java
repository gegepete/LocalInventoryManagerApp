public class NoSuchItemException extends Exception {
    
    public NoSuchItemException() {
        super("This item does not exist (anymore)!");
    }
}