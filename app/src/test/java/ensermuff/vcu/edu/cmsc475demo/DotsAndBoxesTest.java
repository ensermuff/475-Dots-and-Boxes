package ensermuff.vcu.edu.cmsc475demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.mockito.Mock;

import ensermuff.vcu.edu.cmsc475demo.Activities.SettingsActivity;

public class DotsAndBoxesTest {

    //Simple test to make sure default color is correct
    @Test
    public void colorTest() {
        //SettingsActivity.player1Color


        assertEquals("#E91414",SettingsActivity.player1Color);

        SettingsActivity.player1Color = "#32E914";
        SettingsActivity.player2Color = "#32E914";

        assertEquals("#32E914",SettingsActivity.player1Color);
        assertEquals("#32E914",SettingsActivity.player2Color);
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

    //This checks the created lines to see if area is occupied
    @Test
    public void isOccupiedTest(){
        GridPoint myGridPoint = new GridPoint(10,10);
        GridPoint myGridPoint2 = new GridPoint(10,15);

        Line line = new Line(myGridPoint, myGridPoint2, LINE_TYPE.HORIZONTAL);
        GameDataModel.init();
        GameDataModel.LENGTH = 5;

        assertEquals(false, GameDataModel.checkArea(line));

        myGridPoint = new GridPoint(20,10);
        myGridPoint2 = new GridPoint(20,15);

        line = new Line(myGridPoint, myGridPoint2, LINE_TYPE.HORIZONTAL);
        GameDataModel.init();
        GameDataModel.LENGTH = 5;

        assertEquals(false, GameDataModel.checkArea(line));

        myGridPoint = new GridPoint(50,10);
        myGridPoint2 = new GridPoint(60,15);

        line = new Line(myGridPoint, myGridPoint2, LINE_TYPE.HORIZONTAL);
        GameDataModel.init();
        GameDataModel.LENGTH = 15;

        assertEquals(false, GameDataModel.checkArea(line));
    }

}