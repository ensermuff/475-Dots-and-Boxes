package ensermuff.vcu.edu.cmsc475demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    GameCanvas gameCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);
        gameCanvas = new GameCanvas(this);
        gameCanvas.setBackgroundColor(Color.WHITE);
        setContentView(gameCanvas);
    }
}