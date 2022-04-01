package ensermuff.vcu.edu.cmsc475demo.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import ensermuff.vcu.edu.cmsc475demo.GameDataModel;
import ensermuff.vcu.edu.cmsc475demo.GameView;
import ensermuff.vcu.edu.cmsc475demo.R;

public class GameActivity extends AppCompatActivity {

    public static String player1 = "player1";
    public static String player2 = "player2";
    GameView view;
    GameDataModel model;
    Intent intent;
    MediaPlayer mySongs;

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
                if (mySongs.isPlaying()){
                    mySongs.pause();
                }else{
                    mySongs.start();
                }
                openDialog();
            }
        });

        Button myUndo = findViewById(R.id.undoTurn);
        myUndo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                
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

        Button cancelBtn = menuDialog.findViewById(R.id.dialog_resume);
        Button okBtn = menuDialog.findViewById(R.id.dialog_menu);
        Button resetBtn = menuDialog.findViewById(R.id.dialog_reset);

        cancelBtn.setOnClickListener((v) ->{

            //Resume song
            onResume();

            menuDialog.dismiss();
        });

        resetBtn.setOnClickListener((v) ->{
            Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
            startActivity(startIntent);
        });

        okBtn.setOnClickListener((v) ->{
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startIntent);
            //Stop song
            mySongs.stop();
        });

        menuDialog.show();


    }

}