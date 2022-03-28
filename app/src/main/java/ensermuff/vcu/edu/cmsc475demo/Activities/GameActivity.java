package ensermuff.vcu.edu.cmsc475demo.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import ensermuff.vcu.edu.cmsc475demo.GameView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import ensermuff.vcu.edu.cmsc475demo.MenuDialog;
import ensermuff.vcu.edu.cmsc475demo.R;
import ensermuff.vcu.edu.cmsc475demo.GameDataModel;
import ensermuff.vcu.edu.cmsc475demo.GameView;

public class GameActivity extends AppCompatActivity {

    public static String player1 = "player1";
    public static String player2 = "player2";
    GameView view;
    GameDataModel model;
    Intent intent;
    MediaPlayer mySongs;
    MenuDialog myMenuDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        intent = getIntent();
        player1 = intent.getStringExtra("player1");
        player2 = intent.getStringExtra("player2");

        mySongs = MediaPlayer.create(getApplicationContext(), R.raw.releasethefire);
        mySongs.start();


        Button myMenu = findViewById(R.id.menu);
        myMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mySongs.isPlaying()){
                    mySongs.pause();
                }else{
                    mySongs.start();
                }
                openDialog();
            }
        });


        Display display = getWindowManager().getDefaultDisplay();
        //Point screenSize = new Point(1000, 1500); // Entire device screen is x=1440 and y=2701
        Point screenSize = new Point();
        display.getSize(screenSize); // Entire device screen is x=1440 and y=2701
        Log.d("ddamddi", " [SIZE]   WIDTH:" + screenSize.x + " HEIGHT:" + screenSize.y);
        model = new GameDataModel(screenSize);
        view = new GameView(this, model);
        // setContentView(view);
        ConstraintLayout myView = (ConstraintLayout) findViewById(R.id.linearLayout);
        myView.addView(view);
//        LinearLayout v = (LinearLayout) findViewById(R.id.linearLayout);
//        v.addView(view);
    }

    public void openDialog() {

        MenuDialog menuDialog = new MenuDialog();
        menuDialog.show(getSupportFragmentManager(), "Testing");
    }

}