package ensermuff.vcu.edu.cmsc475demo.Activities;

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
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

import ensermuff.vcu.edu.cmsc475demo.GameDataModel;
import ensermuff.vcu.edu.cmsc475demo.GameView;
import ensermuff.vcu.edu.cmsc475demo.R;

public class GameActivity extends AppCompatActivity {

    public static String player1 = "player1";
    public static String player2 = "player2";
    public static boolean infoGame = true;
    public static ArrayList<String> historyList = new ArrayList<>();
    String player1Color = SettingsActivity.player1Color;
    String player2Color = SettingsActivity.player2Color;
    GameView view;
    GameDataModel model;
    Intent intent;
    MediaPlayer mySongs;
    MediaPlayer clickSounds;
    ConstraintLayout myView;
    TextView theWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        intent = getIntent();
        player1 = intent.getStringExtra("player1");
        player2 = intent.getStringExtra("player2");

        clickSounds = MediaPlayer.create(getApplicationContext(), R.raw.mixkit_interface_click_1126);

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
                if(SettingsActivity.sounds){
                    clickSounds.start();
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
        //player Names
        setPlayerNames();
        // setContentView(view);
        myView = findViewById(R.id.linearLayout);
        myView.addView(view);
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

    public void setGameOver(String winner){
        TextView gameOverText = findViewById(R.id.GameOverText);
        TextView restart = findViewById(R.id.restartText);
        gameOverText.setText(winner);
        restart.setText("Touch screen to restart");
    }

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

    @Override
    public void onPause() {
        super.onPause();
        mySongs.stop();
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
        if(!SettingsActivity.sounds){
            soundBtn.setImageResource(R.drawable.sound_off);
        }


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
                //sound on by default
                if(SettingsActivity.sounds){
                    SettingsActivity.sounds = false; //sets boolean to remove click sounds
                    soundBtn.setImageResource(R.drawable.sound_off);
                } else {
                    SettingsActivity.sounds = true; //sets boolean to add sounds
                    soundBtn.setImageResource(R.drawable.sound_on);
                }

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
        ListView listView = findViewById(R.id.listHistory);

        winDialogHomeBtn.setOnClickListener((v) ->{
            infoGame = true;

            String addp1Score = String.valueOf(model.getPlayers()[0].getScore());
            String addp2Score = String.valueOf(model.getPlayers()[1].getScore());

            if(historyList.size() == 5){
                HistoryActivity.removeHistory(SettingsActivity.player1Name+"= "+addp1Score+" "+SettingsActivity.player2Name+"= "+addp2Score);
            }else{
                //Adding score to history
                HistoryActivity.addHistory(SettingsActivity.player1Name+"= "+addp1Score+" "+SettingsActivity.player2Name+"= "+addp2Score);
            }

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
}