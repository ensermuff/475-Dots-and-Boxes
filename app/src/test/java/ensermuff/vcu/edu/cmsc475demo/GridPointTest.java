package ensermuff.vcu.edu.cmsc475demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridPointTest {

    @Test
    public void testEquals() {
        GridPoint p1 = new GridPoint(4, 4);
        GridPoint p2 = new GridPoint(4, 4);
        GridPoint p3 = new GridPoint(6, 6);

        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p3.equals("test"));
    }
}