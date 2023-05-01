package ensermuff.vcu.edu.cmsc475demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import android.graphics.Point;

import org.junit.Test;

public class GameDataModelTest {

    @Test
    public void testInit() {
        Point screenSize = new Point(1400, 2701); // Entire device screen is x=1440 and y=2701
        GameDataModel myGameDataModel = new GameDataModel(screenSize);
        myGameDataModel.setGridSize(screenSize);
        GameDataModel.setLENGTH(60);
        GameDataModel.init();

        // Checking if GRID and LENGTH values are properly set
        assertEquals(5, GameDataModel.GRID);
        assertEquals(60, GameDataModel.LENGTH);

        // Checking if areas array is properly initialized
        for (int x = 0; x < GameDataModel.GRID; x++) {
            for (int y = 0; y < GameDataModel.GRID; y++) {
                assertNotNull(GameDataModel.areas[x][y]);
            }
        }

        // Checking if lines array is properly initialized
        assertEquals(2 * GameDataModel.GRID * (GameDataModel.GRID + 1), GameDataModel.getLines().size());

        // Checking if gridPoints array is properly initialized
        for (int x = 0; x < GameDataModel.GRID + 1; x++) {
            for (int y = 0; y < GameDataModel.GRID + 1; y++) {
                assertNotNull(myGameDataModel.getGridPoints()[x][y]);
            }
        }

        // Checking if players array is properly initialized
        assertNotNull(GameDataModel.getPlayers()[0]);
        assertNotNull(GameDataModel.getPlayers()[1]);

        // Checking if turn, isGameOver, isDrawGame, and isBack are properly initialized
        assertEquals(0, GameDataModel.turn);
        assertFalse(GameDataModel.isGameOver);
        assertFalse(GameDataModel.isDrawGame);
        assertFalse(GameDataModel.isBack);
    }
}
