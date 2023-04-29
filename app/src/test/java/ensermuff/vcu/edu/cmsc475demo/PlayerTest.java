package ensermuff.vcu.edu.cmsc475demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    Player myPlayer;

    @Before
    public void setUp() {
        myPlayer = new Player();
    }

    @Test
    public void TestGetAndSetScore() {
        assertEquals(0, myPlayer.getScore());
        myPlayer.setScore(4);
        assertEquals(4, myPlayer.getScore());
    }

    @Test
    public void TestEraseScore() {
        myPlayer.setScore(4);
        assertEquals(4, myPlayer.getScore());
        myPlayer.eraseScore();
        assertEquals(0, myPlayer.getScore());
    }

    @Test
    public void TestAddAndSubstractScore() {
        myPlayer.addScore();
        assertEquals(1, myPlayer.getScore());
        myPlayer.subtractScore();
        assertEquals(0, myPlayer.getScore());
    }

}