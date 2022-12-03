public class PlayerMoveException extends RuntimeException {

    public PlayerMoveException() {
        super("You chose an impossible move! Try again\n");
    }
}
