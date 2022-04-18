package ensermuff.vcu.edu.cmsc475demo;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.sql.Types.NULL;

import android.app.Instrumentation;

import androidx.annotation.ContentView;
import androidx.test.platform.app.InstrumentationRegistry;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ensermuff.vcu.edu.cmsc475demo.Activities.GameActivity;
import ensermuff.vcu.edu.cmsc475demo.Activities.MainActivity;
import ensermuff.vcu.edu.cmsc475demo.Activities.SettingsActivity;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DotsAndBoxesTest {

    //Simple test to make sure default color is correct
    @Test
    public void colorTest() {

        assertEquals("#fc4e42", SettingsActivity.player1Color);
    }

    //Testing grid size
    @Test
    public void checkGrid() {
        SettingsActivity.gridSet = GameDataModel.GRID;
        assertEquals(5, SettingsActivity.gridSet);

        SettingsActivity.gridSet = 6;
        assertEquals(6, SettingsActivity.gridSet);
    }

    //Testing isDrawGame is set to true or false.
    @Test
    public void isDrawGameTest() {
        GameDataModel.isDrawGame = true;
        assertTrue(GameDataModel.isDrawGame);

        GameDataModel.init();
        assertFalse(GameDataModel.isDrawGame);

        Area[][] testAreas = GameDataModel.areas;
        assertEquals(testAreas, testAreas);
    }

    //This checks to see if area is occupied
    @Test
    public void isOccupiedTest(){
        GridPoint myGridPoint = new GridPoint(10,10);
        GridPoint myGridPoint2 = new GridPoint(10,15);

        Line line = new Line(myGridPoint, myGridPoint2, LINE_TYPE.HORIZONTAL);
        GameDataModel.init();
        GameDataModel.LENGTH = 5;

        assertEquals(false, GameDataModel.checkArea(line));
    }
}