import junit.framework.TestCase;

public class GameboardTest extends TestCase
{
    public GameboardTest(String name) {
        super(name);
    }

    /**
     * Test method that checks if a cell can be added. Asserts true if two cells are found. One when the gameboard
     * is first made, and another after addCell() runs
     */
    public void testAddCell() {
        GameBoard gameboard = new GameBoard();
        assertEquals(1, gameboard.getCellNumber());
        Cell cell = new Cell();
        gameboard.addCell(cell);
        assertEquals(2, gameboard.getCellNumber());
    }

    /**
     * Test method that checks if a cell is added when the gameboard is first made.
     */
    public void testFirstCell() {
        GameBoard gameboard = new GameBoard();
        Cell firstCell = gameboard.getCell(0);
        assertSame(GoCell.class, firstCell.getClass());
    }

    /**
     * Test method that checks if getCellIndex() runs properly. Asserts true if Blue2 cell is found at index 2.
     * Asserts true if a cell is not found outside the index.
     */
    public void testGetCellIndex() {
        GameBoard gameBoard = new SimpleGameBoard();
        Cell blue2 = gameBoard.getCell(2);
        int index = gameBoard.getCellIndex(blue2);
        assertEquals(2, index);
        Cell notExist = new Cell();
        index = gameBoard.getCellIndex(notExist);
        assertEquals(-1, index);
    }
}
