package ensermuff.vcu.edu.cmsc475demo;

import static org.junit.Assert.*;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import org.junit.Test;

public class LineTest {

    @Test
    public void testConstructor() {
        GridPoint p1 = new GridPoint(0, 0);
        GridPoint p2 = new GridPoint(0, 5);
        Line myLine = new Line(p1, p2, LINE_TYPE.VERTICAL);
        assertEquals(p1, myLine.getP1());
        assertEquals(p2, myLine.getP2());
        assertFalse(myLine.getDraw());
        assertEquals(LINE_TYPE.VERTICAL, myLine.getLINE_TYPE());
        assertNotNull(myLine.getPaint());
    }
    @Test
    public void testGettersAndSetters() {
        GridPoint p1 = new GridPoint(0, 0);
        GridPoint p2 = new GridPoint(6, 0);
        Line myLine = new Line(p1, p2, LINE_TYPE.HORIZONTAL);

        assertEquals(LINE_TYPE.HORIZONTAL, myLine.getLINE_TYPE());

        myLine.setDraw(true);
        assertTrue(myLine.getDraw());

        Paint paint = new Paint();
        myLine.setPaint(paint);
        assertEquals(paint, myLine.getPaint());

        myLine.setColor("#1443E9");
        assertEquals(Color.parseColor("#1443E9"), myLine.getPaint().getColor());

        myLine.getPaint().setColor(Color.parseColor("#E91414")); //Red color
        assertEquals(Color.parseColor("#E91414"), myLine.getPaint().getColor());
        assertEquals(new GridPoint(3, 0), myLine.getCenter());
    }

}