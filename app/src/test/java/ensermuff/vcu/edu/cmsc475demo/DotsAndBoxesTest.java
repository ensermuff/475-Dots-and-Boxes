package ensermuff.vcu.edu.cmsc475demo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.sql.Types.NULL;

import ensermuff.vcu.edu.cmsc475demo.Activities.SettingsActivity;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DotsAndBoxesTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //Simple test to make sure default color is correct
    @Test
    public void  colorTest(){
        assertEquals("#fc4e42", SettingsActivity.player1Color);
    }
}