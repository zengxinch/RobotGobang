package robot;

public class StupidRobot implements IRobot {
    private static final short ROLE_OPPONENT = 1;
    private static final short ROLE_ROBOT = 2;
    private static final short ROLE_NON = 0;

    private int[][] boardRef = null;


    /**
     * There we provide a default implementation to simulate robot's behavior
     *
     * @return a {@code robot.Pair} which contains a valid (x,y) position
     */
    @Override
    public Pair getDeterminedPos() {
        return null;
    }

    /**
     * This method is used to retrieve game board such that robot can determine its (x,y) position
     *
     * @param gameBoard the 2-dimension array to represent the game board
     */
    @Override
    public void retrieveGameBoard(int[][] gameBoard) {
        boardRef = gameBoard;
    }


    private void maxMinSearch(){

    }
}
