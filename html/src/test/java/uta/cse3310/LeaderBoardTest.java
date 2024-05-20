package uta.cse3310;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LeaderBoardTest {

    private LeaderBoard leaderBoard;

    @Before
    public void setUp() {
        leaderBoard = new LeaderBoard();
    }

    @Test
    public void testAddScore() {
        leaderBoard.addScore("Player1", 100);
        assertEquals(1, leaderBoard.getHighScores().size());
        assertEquals("Player1", leaderBoard.getTopPlayerName());
        assertEquals(100, leaderBoard.getTopScore());

        // Adding score for an existing player
        leaderBoard.addScore("Player1", 50);
        assertEquals(1, leaderBoard.getHighScores().size());
        assertEquals(150, leaderBoard.getTopScore());

        // Adding score for a new player
        leaderBoard.addScore("Player2", 200);
        assertEquals(2, leaderBoard.getHighScores().size());
        assertEquals("Player2", leaderBoard.getTopPlayerName());
        assertEquals(200, leaderBoard.getTopScore());
    }

    @Test
    public void testGetTopPlayerName() {
        assertNull(leaderBoard.getTopPlayerName());

        leaderBoard.addScore("Player1", 100);
        assertEquals("Player1", leaderBoard.getTopPlayerName());
    }

    @Test
    public void testGetTopScore() {
        assertEquals(0, leaderBoard.getTopScore());

        leaderBoard.addScore("Player1", 100);
        assertEquals(100, leaderBoard.getTopScore());
    }

    @Test
    public void testEmptyLeaderBoard() {
        assertTrue(leaderBoard.getHighScores().isEmpty());
        assertNull(leaderBoard.getTopPlayerName());
        assertEquals(0, leaderBoard.getTopScore());
    }
}
