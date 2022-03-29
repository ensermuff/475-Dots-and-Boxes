package ensermuff.vcu.edu.cmsc475demo.Activities;

import static ensermuff.vcu.edu.cmsc475demo.GameDataModel.checkArea;
import static ensermuff.vcu.edu.cmsc475demo.GameDataModel.getNowPlayer;
import static ensermuff.vcu.edu.cmsc475demo.Line.*;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import ensermuff.vcu.edu.cmsc475demo.Area;
import ensermuff.vcu.edu.cmsc475demo.GameView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import ensermuff.vcu.edu.cmsc475demo.GridPoint;
import ensermuff.vcu.edu.cmsc475demo.LINE_TYPE;
import ensermuff.vcu.edu.cmsc475demo.Line;
import ensermuff.vcu.edu.cmsc475demo.MenuDialog;
import ensermuff.vcu.edu.cmsc475demo.Player;
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

    GridPoint lastPoint;
    GridPoint lastPoint2;
    LINE_TYPE lastLineType;

    Line myline;

//    Player[] playerArr = model.getPlayers();

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
        Button undoTurn = findViewById(R.id.undoTurn);
        undoTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //first check if the area is filled up using if condition
                //  if area is filled then remove that area and set getOwner to 0 and call Area.draw to draw area to white
                //      then remove the line
                //      then subtract score
                //  else
                //      remove the player's colored line
                //      then subtract the player's score

                // Create 5 arraylists
                ArrayList<GridPoint> p1 = new ArrayList<>();
                ArrayList<GridPoint> p2 = new ArrayList<>();
                ArrayList<LINE_TYPE> line_types = new ArrayList<>();
                ArrayList<Line> lines = new ArrayList<>();
                ArrayList<Area> areas = new ArrayList<>();
                for(int i = 0; i < lines.size() - 1; i++){

                }
//                if (){
//                    Area myArea = new Area();
//                    myArea.
//                    myArea.setOwner(0);
//                    myArea.setOccupied(false);
//                    getNowPlayer().subtractScore();

//                }else {
//                    getNowPlayer().subtractScore();
//                }
//                lastPoint = GameView.getLastPoint();
//                lastPoint2 = GameView.getLasttPoint2();
//                lastLineType = GameView.getLastLineType();
//                new Line(lastPoint, lastPoint2, lastLineType);
//                Area myArea = new Area();
//                myArea.setOwner(0);
//                myArea.setOccupied(false);
//                getNowPlayer().subtractScore();


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