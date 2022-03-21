package ensermuff.vcu.edu.cmsc475demo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public class Area {
    private boolean isOccupied;
    private int owner;
    private Rect square;
    private Paint paint;
    private ArrayList<Line> neighborLines;

    public Area() {
        this.isOccupied = false;
        this.owner = 0;
        this.square = new Rect();
        this.paint = new Paint();
        this.neighborLines = new ArrayList<>();
    }

    public boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public ArrayList<Line> getNeighborLines() {
        return neighborLines;
    }

    public void addNeighborLine(Line line) {
        neighborLines.add(line);
    }

    public boolean isLocked() {
        for (Line line : neighborLines) {
            if (line.getDraw())
                continue;
            else
                return false;
        }
        return true;
    }

    public GridPoint getCenter() {
        int c_x = 0, c_y = 0;
        for (Line line : neighborLines) {
            c_x += line.getCenter().getX();
            c_y += line.getCenter().getY();
        }
        return new GridPoint(c_x / 4, c_y / 4);
    }

    public void draw(Canvas canvas) {
        if (getOwner() == 0)
            paint.setColor(Color.WHITE);
        else if (getOwner() == 1)
            paint.setColor(Color.RED);
        else if (getOwner() == 2)
            paint.setColor(Color.BLUE);

        //Setting up squares and colors
        square.set(getCenter().getX() - GameDataModel.getLENGTH() / 3, getCenter().getY() - GameDataModel.getLENGTH() / 3,
                getCenter().getX() + GameDataModel.getLENGTH() / 3, getCenter().getY() + GameDataModel.getLENGTH() / 3);
        canvas.drawRect(square, paint);
    }
}
