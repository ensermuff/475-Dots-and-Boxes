package ensermuff.vcu.edu.cmsc475demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.graphics.Canvas;
import android.graphics.Rect;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class AreaTest {

    private Area myArea;

    @Before
    public void setUp() throws Exception {
        myArea = new Area();
    }

    @Test
    public void TestGetOccupied() {
        assertFalse(myArea.getOccupied());
    }

    @Test
    public void TestSetOccupied() {
        myArea.setOccupied(true);
        assertTrue(myArea.getOccupied());
    }

    @Test
    public void TestGetOwner() {
        assertEquals(0, myArea.getOwner());
    }

    @Test
    public void TestSetOwner() {
        myArea.setOwner(1);
        assertEquals(1, myArea.getOwner());
    }
    @Test
    public void TestSetOwner2() {
        myArea.setOwner(2);
        assertEquals(2, myArea.getOwner());
    }

    @Test
    public void TestGetNeighborLines() {
        ArrayList<Line> neighborLines = myArea.getNeighborLines();
        assertNotNull(neighborLines);
        assertTrue(neighborLines.isEmpty());
    }

    @Test
    public void TestAddNeighborLine() {
        Line myLine = new Line(new GridPoint(0,0), new GridPoint(0, 1), LINE_TYPE.HORIZONTAL);
        myArea.addNeighborLine(myLine);
        ArrayList<Line> neighborLines = myArea.getNeighborLines();
        assertEquals(1, neighborLines.size());
        assertEquals(myLine, neighborLines.get(0));
    }

    @Test
    public void TestIsLockedWhenAllLinesAreDrawn() {
        ArrayList<Line> neighborLines = new ArrayList<>();
        Line line = new Line(new GridPoint(0,0), new GridPoint(0,1), LINE_TYPE.HORIZONTAL);
        Line line2 = new Line(new GridPoint(0,1), new GridPoint(1,1), LINE_TYPE.VERTICAL);
        Line line3 = new Line(new GridPoint(1,1), new GridPoint(1,0), LINE_TYPE.HORIZONTAL);
        Line line4 = new Line(new GridPoint(1,0), new GridPoint(0,0), LINE_TYPE.VERTICAL);

        line.setDraw(true);
        line2.setDraw(true);
        line3.setDraw(true);
        line4.setDraw(true);

        neighborLines.add(line);
        neighborLines.add(line2);
        neighborLines.add(line3);
        neighborLines.add(line4);
        myArea.getNeighborLines().addAll(neighborLines);
        assertTrue(myArea.isLocked());
    }
    @Test
    public void TestIsLockedWhenNotAllLinesAreDrawn() {
        ArrayList<Line> neighborLines = new ArrayList<>();
        Line line = new Line(new GridPoint(0,0), new GridPoint(0,1), LINE_TYPE.HORIZONTAL);
        Line line2 = new Line(new GridPoint(0,1), new GridPoint(1,1), LINE_TYPE.VERTICAL);
        Line line3 = new Line(new GridPoint(1,1), new GridPoint(1,0), LINE_TYPE.HORIZONTAL);
        Line line4 = new Line(new GridPoint(1,0), new GridPoint(0,0), LINE_TYPE.VERTICAL);

        line.setDraw(true);
        line2.setDraw(true);
        line3.setDraw(true);

        neighborLines.add(line);
        neighborLines.add(line2);
        neighborLines.add(line3);
        neighborLines.add(line4);
        myArea.getNeighborLines().addAll(neighborLines);
        assertFalse(myArea.isLocked());
    }

    @Test
    public void TestGetCenter() {
        ArrayList<Line> neighborLines = new ArrayList<>();
        Line line = new Line(new GridPoint(0,0), new GridPoint(0,2), LINE_TYPE.HORIZONTAL);
        Line line2 = new Line(new GridPoint(0,2), new GridPoint(2,2), LINE_TYPE.VERTICAL);
        Line line3 = new Line(new GridPoint(2,2), new GridPoint(2,0), LINE_TYPE.HORIZONTAL);
        Line line4 = new Line(new GridPoint(2,0), new GridPoint(0,0), LINE_TYPE.VERTICAL);
        line.setDraw(true);
        line2.setDraw(true);
        line3.setDraw(true);
        line4.setDraw(true);
        neighborLines.add(line);
        neighborLines.add(line2);
        neighborLines.add(line3);
        neighborLines.add(line4);
        myArea.getNeighborLines().addAll(neighborLines);
        GridPoint center = myArea.getCenter();
        assertEquals(1, center.getX());
        assertEquals(1, center.getY());
    }

    @Test
    public void TestDraw() {
        Area myArea = new Area();
        Canvas myCanvas = mock(Canvas.class);
        Rect expectedSquare = new Rect();
//        when(myCanvas.drawRect());
    }

    @Test
    public void TestIsOccupied() {
        Area myArea = new Area();
        assertFalse(myArea.isOccupied());
        myArea.setOccupied(true);
        assertTrue(myArea.isOccupied());
    }

    @Test
    public void TestGetSquare() {
        Area myArea = new Area();
        assertNotNull(myArea.getSquare());
    }

    @Test
    public void TestGetPaint() {
        Area myArea = new Area();
        assertNotNull(myArea.getPaint());
    }
}