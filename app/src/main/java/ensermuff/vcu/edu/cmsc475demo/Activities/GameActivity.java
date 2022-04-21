package ensermuff.vcu.edu.cmsc475demo.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import ensermuff.vcu.edu.cmsc475demo.GameDataModel;
import ensermuff.vcu.edu.cmsc475demo.GameView;
import ensermuff.vcu.edu.cmsc475demo.R;

public class GameActivity extends AppCompatActivity {

    public static String player1 = "player1";
    public static String player2 = "player2";
    public static boolean infoGame = true;
    GameView view;
    GameDataModel model;
    Intent intent;
    MediaPlayer mySongs;
    ConstraintLayout myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        intent = getIntent();
        player1 = intent.getStringExtra("player1");
        player2 = intent.getStringExtra("player2");

        mySongs = MediaPlayer.create(getApplicationContext(), R.raw.schemingweasal);
        mySongs.setLooping(true);
        mySongs.start();


        Button myMenu = findViewById(R.id.menu);
        myMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        Button myUndo = findViewById(R.id.undoTurn);
        myUndo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view2) {
                view.undo();
                // redraw the canvas over again with the updated arrayList of type line and updated arrayList of type area
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
        myView = (ConstraintLayout) findViewById(R.id.linearLayout);
        myView.addView(view);

//        if (model.checkGameOver()){
//            // call the winningdialog
//            openWinningDialog();
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mySongs != null)
            mySongs.start();
    }

    public void openDialog() {
        final Dialog menuDialog = new Dialog(GameActivity.this);
        //added custom view to dialog with no title
        menuDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //menuDialog.show(getSupportFragmentManager(), "Testing");
        menuDialog.setCancelable(true);
        //Mention the name of the custom dialog
        menuDialog.setContentView(R.layout.menudialog);

        ImageButton infoBtn = menuDialog.findViewById(R.id.dialog_info);
        ImageButton resumeBtn = menuDialog.findViewById(R.id.dialog_resume);
        ImageButton menuBtn = menuDialog.findViewById(R.id.dialog_home);
        ImageButton resetBtn = menuDialog.findViewById(R.id.dialog_reset);
        ImageButton musicBtn = menuDialog.findViewById(R.id.dialog_music);
        if(!mySongs.isPlaying()){
            musicBtn.setImageResource(R.drawable.music_off);
        }
        ImageButton soundBtn = menuDialog.findViewById(R.id.dialog_sound);


        infoBtn.setOnClickListener((v) ->{
            infoGame = false;
            Intent startIntent = new Intent(getApplicationContext(), InformationActivity.class);
            startActivity(startIntent);
            mySongs.pause();
            //finish command destroys the current activity (in this case the GameActivity)
            finish();
            //openInfoDialog();
        });
        resumeBtn.setOnClickListener((v) ->{
            menuDialog.dismiss();
        });

        resetBtn.setOnClickListener((v) ->{
            Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
            mySongs.stop();
            startActivity(startIntent);

        });
        musicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Song is playing by default
                if(mySongs.isPlaying()) {
                    //Stops song
                    mySongs.pause();
                    musicBtn.setImageResource(R.drawable.music_off);
                }else{
                    //Resumes song
                    mySongs.start();
                    musicBtn.setImageResource(R.drawable.music_on);
                }
            }
        });
        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        menuBtn.setOnClickListener((v) ->{
            infoGame = true;
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startIntent);
            //Stop song
            mySongs.stop();
        });

        menuDialog.show();
    }

    public void openWinningDialog() {
        final Dialog winningDialog = new Dialog(GameActivity.this);
        //added custom view to dialog with no title
        winningDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        winningDialog.setCancelable(true);
        //Mention the name of the custom dialog
        winningDialog.setContentView(R.layout.winningdialog);
        TextView theWinner = findViewById(R.id.winner);
        String winner = GameView.winner;
        if (winner == "Player 1"){
            theWinner.setText("Winner is Player 1");
        }else {
            theWinner.setText("Winner is Player 2");
        }
        winningDialog.show();

    }
    /*public void openInfoDialog(){
        final Dialog menuDialog = new Dialog(GameActivity.this);
        //added custom view to dialog with no title
        menuDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        menuDialog.setCancelable(false);
        //Mention the name of the custom dialog
        menuDialog.setContentView(R.layout.activity_information);

        Button infoBtn = menuDialog.findViewById(R.id.returnBtn);

        infoBtn.setOnClickListener((v) ->{
            menuDialog.dismiss();
        });

        menuDialog.show();
    }*/

}