package ensermuff.vcu.edu.cmsc475demo.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import java.util.Set;

import ensermuff.vcu.edu.cmsc475demo.GameDataModel;
import ensermuff.vcu.edu.cmsc475demo.GameView;
import ensermuff.vcu.edu.cmsc475demo.R;

public class GameActivity extends AppCompatActivity {

    public static String player1 = "player1";
    public static String player2 = "player2";
    public static boolean infoGame = true;
    String player1Color = SettingsActivity.player1Color;
    String player2Color = SettingsActivity.player2Color;
    GameView view;
    GameDataModel model;
    Intent intent;
    MediaPlayer mySongs;
    ConstraintLayout myView;
    TextView theWinner;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        intent = getIntent();
        player1 = intent.getStringExtra("player1");
        player2 = intent.getStringExtra("player2");

        if (SettingsActivity.songNumber == 1){
            mySongs = MediaPlayer.create(getApplicationContext(), R.raw.schemingweasal);
        }else if (SettingsActivity.songNumber == 2){
            mySongs = MediaPlayer.create(getApplicationContext(), R.raw.nospampolka);
        }else if (SettingsActivity.songNumber == 3){
            mySongs = MediaPlayer.create(getApplicationContext(), R.raw.techlive);
        }
        mySongs.setLooping(true);
        mySongs.start();



        Button myMenu = findViewById(R.id.menu);
        myMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

//        Button myUndo = findViewById(R.id.undoTurn);
//        myUndo.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view2) {
//                view.undo();
//                // redraw the canvas over again with the updated arrayList of type line and updated arrayList of type area
//            }
//        });


        Display display = getWindowManager().getDefaultDisplay();
        //Point screenSize = new Point(1000, 1500); // Entire device screen is x=1440 and y=2701
        Point screenSize = new Point();
        display.getSize(screenSize); // Entire device screen is x=1440 and y=2701
        Log.d("ddamddi", " [SIZE]   WIDTH:" + screenSize.x + " HEIGHT:" + screenSize.y);
        model = new GameDataModel(screenSize);
        view = new GameView(this, model);
        //player Names
        setPlayerNames();
        // setContentView(view);
        myView = (ConstraintLayout) findViewById(R.id.linearLayout);
        myView.addView(view);

//        if (model.checkGameOver()){
//            // call the winningdialog
//            openWinningDialog();
//        }
    }

    public void setTurn(String myTurn) {
        TextView turn = findViewById(R.id.playerTurn);
        if (myTurn.equals(SettingsActivity.player1Name + "'s Turn")){
            turn.setText(myTurn);
            turn.setTextColor(Color.parseColor(SettingsActivity.player1Color));
        }else{
            turn.setText(myTurn);
            turn.setTextColor(Color.parseColor(SettingsActivity.player2Color));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setPlayerNames() {
        TextView gamePlayer1 = findViewById(R.id.gameP1Name);
        Typeface typeface = getResources().getFont(R.font.syncopate_bold);
        gamePlayer1.setTypeface(typeface);
        gamePlayer1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
        gamePlayer1.setText(SettingsActivity.player1Name + ":\n" + GameDataModel.getPlayers()[0].getScore());
        gamePlayer1.setBackgroundColor(Color.parseColor(SettingsActivity.player1Color));


        TextView gamePlayer2 = findViewById(R.id.gameP2Name);
        gamePlayer2.setTypeface(typeface);
        gamePlayer2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
        gamePlayer2.setText(SettingsActivity.player2Name + ":\n" + GameDataModel.getPlayers()[1].getScore());
        gamePlayer2.setBackgroundColor(Color.parseColor(SettingsActivity.player2Color));
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
        int scorep1 = model.getPlayers()[0].getScore();
        int scorep2 = model.getPlayers()[1].getScore();

        final Dialog winningDialog = new Dialog(GameActivity.this);
        //added custom view to dialog with no title
        winningDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        winningDialog.setCancelable(true);
        //Mention the name of the custom dialog
        winningDialog.setContentView(R.layout.winningdialog);

        //Sets up the background colors for scores
        TextView player1Score = (TextView) winningDialog.findViewById(R.id.dialogWin_scorep1);
        TextView player2Score = (TextView) winningDialog.findViewById(R.id.dialogWin_scorep2);

        //Sets score and background of the players scores
        player1Score.setText(String.valueOf(scorep1));
        player1Score.setBackgroundColor(Color.parseColor(player1Color));

        player2Score.setText(String.valueOf(scorep2));
        player2Score.setBackgroundColor(Color.parseColor(player2Color));

        theWinner = (TextView) winningDialog.findViewById(R.id.textViewWin);
        //TextView theWinner = findViewById(R.id.winner);
        String winner = GameView.winner;
        if (model.getPlayers()[0].getScore() > model.getPlayers()[1].getScore()) {
            theWinner.setText("Winner is " + SettingsActivity.player1Name);
            theWinner.setTextColor(Color.parseColor(player1Color));
        }else if (model.getPlayers()[0].getScore() == model.getPlayers()[1].getScore()){
            theWinner.setText("Draw");
            theWinner.setTextColor(Color.GRAY);
        }else{
            theWinner.setText("Winner is " + SettingsActivity.player2Name);
            theWinner.setTextColor(Color.parseColor(player2Color));
        }

        ImageButton winDialogHomeBtn = winningDialog.findViewById(R.id.dialogWin_home);
        ImageButton winDialogResetBtn = winningDialog.findViewById(R.id.dialogWin_reset);

        winDialogHomeBtn.setOnClickListener((v) ->{
            infoGame = true;
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            mySongs.stop();
            startActivity(startIntent);

        });

        winDialogResetBtn.setOnClickListener((v) ->{
            Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
            mySongs.stop();
            startActivity(startIntent);

        });

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