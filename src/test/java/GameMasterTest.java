import junit.framework.TestCase;

public class GameMasterTest extends TestCase {
    GameMaster master;

    public void setUp() {
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
    }

    /**
     * Test method that checks if the set number of players is found. Six players are first set and returns true if
     * they are set correctly. Another instance is created and checks if there are again six players.
     */
    public void testSingleton() {
        master.setNumberOfPlayers(6);
        assertEquals(6, master.getNumberOfPlayers());
        GameMaster instance1 = GameMaster.instance();
        assertNotNull(instance1);
        GameMaster instance2 = GameMaster.instance();
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    /**
     * Test method that checks if all six players are in their correct position. Six players are created
     * and the method iterates over each player and checks if their positions are correct.
     */
    public void testPlayerInit() {
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        master.setNumberOfPlayers(6);
        assertEquals(6, master.getNumberOfPlayers());
        Cell go = master.getGameBoard().getCell(0);
        for(int i = 0; i < 6; i++) {
            Player player = master.getPlayer(i);
            assertSame(go, player.getPosition());
        }
    }

    /**
     * Test method that checks if players move correctly. Blue 2 is first checked if the player moves to their spot.
     * The player then moves again and checks if they are on Green 2.
     */
    public void testMovePlayerSimple() {
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        master.setNumberOfPlayers(1);
        Player player = master.getPlayer(0);
        master.movePlayer(0,2);
        assertEquals("Blue 2", player.getPosition().getName());
        master.movePlayer(0,3);
        assertEquals("Green 2", player.getPosition().getName());
    }

    /**
     * Test method that checks if when the player moves back to the go cell their start.
     */
    public void testMovePlayerCycle() {
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        master.setNumberOfPlayers(1);
        Player player = master.getPlayer(0);
        master.movePlayer(0,2);
        master.movePlayer(0,5);
        assertEquals("Blue 1", player.getPosition().getName());
    }
}
