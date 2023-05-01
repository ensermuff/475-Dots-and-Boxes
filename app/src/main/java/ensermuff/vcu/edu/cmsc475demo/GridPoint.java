package ensermuff.vcu.edu.cmsc475demo;

public class GridPoint {
    private int x, y;

    public GridPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GridPoint other)) {
            return false;
        }
        return this.x == other.x && this.y == other.y;
    }
}
