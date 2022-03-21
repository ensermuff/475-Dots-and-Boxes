package ensermuff.vcu.edu.cmsc475demo;

public class Player {
    private int score;

    public Player() {
        eraseScore();
    }

    public int getScore() {
        return score;
    }

    public void eraseScore() {
        this.score = 0;
    }

    public void addScore() {
        this.score++;
    }
}
