package ensermuff.vcu.edu.cmsc475demo;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

;import androidx.core.content.ContextCompat;

public class Line {
    static int WIDTH = 25;
    private GridPoint p1, p2;
    private boolean isDraw;

    private Rect bounds;
    private Paint paint;
    private LINE_TYPE line_type;

    public Line(GridPoint p1, GridPoint p2, LINE_TYPE line_type) {
        this.p1 = p1;
        this.p2 = p2;
        this.line_type = line_type;
        this.isDraw = false;

        this.bounds = new Rect();
        paint = new Paint();
        paint.setColor(Color.LTGRAY);
        paint.setStrokeWidth(48);
    }

    public GridPoint getP1() {
        return p1;
    }

    public GridPoint getP2() {
        return p2;
    }

    public boolean getDraw() {
        return isDraw;
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }

    public void setColor(String color) {
        paint.setColor(Color.parseColor(color));
    }
    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Paint getPaint() {
        return paint;
    }

    public LINE_TYPE getLINE_TYPE() {
        return line_type;
    }

    public GridPoint getCenter() {
        return new GridPoint((getP1().getX() + getP2().getX()) / 2, (getP1().getY() + getP2().getY()) / 2);
    }

}
