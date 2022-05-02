package ensermuff.vcu.edu.cmsc475demo.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import ensermuff.vcu.edu.cmsc475demo.GameDataModel;
import ensermuff.vcu.edu.cmsc475demo.R;

public class SettingsActivity extends AppCompatActivity {

    public static String player1Color = "#E91414";
    public static String player2Color = "#1443E9";
    public static int gridSet = 5;
    public static String player1Name = "Player1";
    public static String player2Name = "Player2";

    public static boolean touchp1Red = true;
    public static boolean touchp1Blue = false;
    public static boolean touchp1Green = false;
    public static boolean touchp1LightBlue = false;
    public static boolean touchp1Purple = false;
    public static boolean touchp1Orange = false;
    public static boolean touchp1Brown = false;

    public static boolean touchp2Red = false;
    public static boolean touchp2Blue = true;
    public static boolean touchp2Green = false;
    public static boolean touchp2LightBlue = false;
    public static boolean touchp2Purple = false;
    public static boolean touchp2Orange = false;
    public static boolean touchp2Brown = false;
    public String tmpColor;
    public static int songNumber=1;
    public static boolean sounds = true;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RadioButton grid6x6;
    RadioButton grid5x5;
    RadioButton grid4x4;
    RadioButton song1;
    RadioButton song2;
    RadioButton song3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);


        ImageButton backBtn = findViewById(R.id.settingsBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is an action being requested that the device should try to perform
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity() is used to launch another activity
                startActivity(startIntent);
            }
        });

        //Makes sure to check color is true
        colorCheck();

        //Sets the value of the player1 colors
        ImageButton p1RedBtn = findViewById(R.id.p1RedBtn);
        p1RedBtn.setOnClickListener((v) -> {

            touchp1Red = true;
            touchp1Blue = false;
            touchp1Green = false;
            touchp1LightBlue = false;
            touchp1Purple = false;
            touchp1Orange = false;
            touchp1Brown = false;

            colorCheck();
        });

        ImageButton p1BlueBtn = findViewById(R.id.p1BlueBtn);
        p1BlueBtn.setOnClickListener((v) -> {

            touchp1Red = false;
            touchp1Blue = true;
            touchp1Green = false;
            touchp1LightBlue = false;
            touchp1Purple = false;
            touchp1Orange = false;
            touchp1Brown = false;

            colorCheck();
        });

        ImageButton p1GreenBtn = findViewById(R.id.p1GreenBtn);
        p1GreenBtn.setOnClickListener((v) -> {

            touchp1Red = false;
            touchp1Blue = false;
            touchp1Green = true;
            touchp1LightBlue = false;
            touchp1Purple = false;
            touchp1Orange = false;
            touchp1Brown = false;

            colorCheck();
        });

        ImageButton p1LightBlueBtn = findViewById(R.id.p1LightBlueBtn);
        p1LightBlueBtn.setOnClickListener((v) -> {
            touchp1Red = false;
            touchp1Blue = false;
            touchp1Green = false;
            touchp1LightBlue = true;
            touchp1Purple = false;
            touchp1Orange = false;
            touchp1Brown = false;

            colorCheck();
        });

        ImageButton p1PurpleBtn = findViewById(R.id.p1PurpleBtn);
        p1PurpleBtn.setOnClickListener((v) -> {
            touchp1Red = false;
            touchp1Blue = false;
            touchp1Green = false;
            touchp1LightBlue = false;
            touchp1Purple = true;
            touchp1Orange = false;
            touchp1Brown = false;

            colorCheck();
        });

        ImageButton p1OrangeBtn = findViewById(R.id.p1OrangeBtn);
        p1OrangeBtn.setOnClickListener((v) -> {
            touchp1Red = false;
            touchp1Blue = false;
            touchp1Green = false;
            touchp1LightBlue = false;
            touchp1Purple = false;
            touchp1Orange = true;
            touchp1Brown = false;

            colorCheck();
        });

        ImageButton p1BrownBtn = findViewById(R.id.p1BrownBtn);
        p1BrownBtn.setOnClickListener((v) -> {
            touchp1Red = false;
            touchp1Blue = false;
            touchp1Green = false;
            touchp1LightBlue = false;
            touchp1Purple = false;
            touchp1Orange = false;
            touchp1Brown = true;

            colorCheck();
        });

        //Sets the value of the player1 colors
        ImageButton p2RedBtn = findViewById(R.id.p2RedBtn);
        p2RedBtn.setOnClickListener((v) -> {

            touchp2Red = true;
            touchp2Blue = false;
            touchp2Green = false;
            touchp2LightBlue = false;
            touchp2Purple = false;
            touchp2Orange = false;
            touchp2Brown = false;

            colorCheck();
        });

        ImageButton p2BlueBtn = findViewById(R.id.p2BlueBtn);
        p2BlueBtn.setOnClickListener((v) -> {

            touchp2Red = false;
            touchp2Blue = true;
            touchp2Green = false;
            touchp2LightBlue = false;
            touchp2Purple = false;
            touchp2Orange = false;
            touchp2Brown = false;

            colorCheck();
        });

        ImageButton p2GreenBtn = findViewById(R.id.p2GreenBtn);
        p2GreenBtn.setOnClickListener((v) -> {

            touchp2Red = false;
            touchp2Blue = false;
            touchp2Green = true;
            touchp2LightBlue = false;
            touchp2Purple = false;
            touchp2Orange = false;
            touchp2Brown = false;

            colorCheck();
        });

        ImageButton p2LightBlueBtn = findViewById(R.id.p2LightBlueBtn);
        p2LightBlueBtn.setOnClickListener((v) -> {
            touchp2Red = false;
            touchp2Blue = false;
            touchp2Green = false;
            touchp2LightBlue = true;
            touchp2Purple = false;
            touchp2Orange = false;
            touchp2Brown = false;

            colorCheck();
        });

        ImageButton p2PurpleBtn = findViewById(R.id.p2PurpleBtn);
        p2PurpleBtn.setOnClickListener((v) -> {
            touchp2Red = false;
            touchp2Blue = false;
            touchp2Green = false;
            touchp2LightBlue = false;
            touchp2Purple = true;
            touchp2Orange = false;
            touchp2Brown = false;

            colorCheck();
        });

        ImageButton p2OrangeBtn = findViewById(R.id.p2OrangeBtn);
        p2OrangeBtn.setOnClickListener((v) -> {
            touchp2Red = false;
            touchp2Blue = false;
            touchp2Green = false;
            touchp2LightBlue = false;
            touchp2Purple = false;
            touchp2Orange = true;
            touchp2Brown = false;

            colorCheck();
        });

        ImageButton p2BrownBtn = findViewById(R.id.p2BrownBtn);
        p2BrownBtn.setOnClickListener((v) -> {
            touchp2Red = false;
            touchp2Blue = false;
            touchp2Green = false;
            touchp2LightBlue = false;
            touchp2Purple = false;
            touchp2Orange = false;
            touchp2Brown = true;

            colorCheck();
        });

        grid6x6 = findViewById(R.id.radiobtn6x6);
        grid5x5 = findViewById(R.id.radiobtn5x5);
        grid4x4 = findViewById(R.id.radiobtn4x4);

        loadGridChoices();

        //Sets the value of the grid
        grid6x6.setOnClickListener((v) -> {
            gridSet = 5;
            GameDataModel.GRID = gridSet;
            saveGridChoices();
        });
        grid5x5.setOnClickListener((v) -> {
            gridSet = 4;
            GameDataModel.GRID = gridSet;
            saveGridChoices();
        });
        grid4x4.setOnClickListener((v) -> {
            gridSet = 3;
            GameDataModel.GRID = gridSet;
            saveGridChoices();
        });

        song1 = findViewById(R.id.song1);
        song2 = findViewById(R.id.song2);
        song3 = findViewById(R.id.song3);

        loadSongChoices();

        //Select the music
        song1.setOnClickListener(v -> {
            songNumber = 1;
            saveSongChoices();
        });
        song2.setOnClickListener(v -> {
            songNumber = 2;
            saveSongChoices();
        });
        song3.setOnClickListener(v -> {
            songNumber = 3;
            saveSongChoices();
        });

        playerNames();
    }

    public void playerNames(){
        editor = getSharedPreferences("save", MODE_PRIVATE).edit();
        EditText playerOne = findViewById(R.id.player1Name);
        EditText playerTwo = findViewById(R.id.player2Name);
        Button button = findViewById(R.id.confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1Name = playerOne.getText().toString();
                player2Name = playerTwo.getText().toString();
                editor.putString(player1Name, playerOne.getText().toString());
                editor.putString(player2Name, playerTwo.getText().toString());
                editor.apply();   // Do not forget this to actually store the values
            }
        });
    }
    public void saveGridChoices(){
        SharedPreferences.Editor editor = getSharedPreferences("grid", MODE_PRIVATE).edit();
        editor.putBoolean("gridSize4x4", grid4x4.isChecked());
        editor.putBoolean("gridSize5x5", grid5x5.isChecked());
        editor.putBoolean("gridSize6x6", grid6x6.isChecked());
        editor.apply();
    }
    public void loadGridChoices(){
        sharedPreferences = getSharedPreferences("grid", MODE_PRIVATE);    //PreferenceManager.getDefaultSharedPreferences(this);
        grid4x4.setChecked(sharedPreferences.getBoolean("gridSize4x4", false));
        grid5x5.setChecked(sharedPreferences.getBoolean("gridSize5x5", false));
        grid6x6.setChecked(sharedPreferences.getBoolean("gridSize6x6", true));
    }
    public void saveSongChoices(){
        SharedPreferences.Editor editor = getSharedPreferences("song", MODE_PRIVATE).edit();
        editor.putBoolean("song1", song1.isChecked());
        editor.putBoolean("song2", song2.isChecked());
        editor.putBoolean("song3", song3.isChecked());
        editor.apply();
    }
    public void loadSongChoices(){
        sharedPreferences = getSharedPreferences("song", MODE_PRIVATE);    //PreferenceManager.getDefaultSharedPreferences(this);
        song1.setChecked(sharedPreferences.getBoolean("song1", true));
        song2.setChecked(sharedPreferences.getBoolean("song2", false));
        song3.setChecked(sharedPreferences.getBoolean("song3", false));
    }



    public void colorCheck() {
        ImageButton p1RedBtn = findViewById(R.id.p1RedBtn);
        ImageButton p1BlueBtn = findViewById(R.id.p1BlueBtn);
        ImageButton p1GreenBtn = findViewById(R.id.p1GreenBtn);
        ImageButton p1LightBlueBtn = findViewById(R.id.p1LightBlueBtn);
        ImageButton p1PurpleBtn = findViewById(R.id.p1PurpleBtn);
        ImageButton p1OrangeBtn = findViewById(R.id.p1OrangeBtn);
        ImageButton p1BrownBtn = findViewById(R.id.p1BrownBtn);

        ImageButton p2RedBtn = findViewById(R.id.p2RedBtn);
        ImageButton p2BlueBtn = findViewById(R.id.p2BlueBtn);
        ImageButton p2GreenBtn = findViewById(R.id.p2GreenBtn);
        ImageButton p2LightBlueBtn = findViewById(R.id.p2LightBlueBtn);
        ImageButton p2PurpleBtn = findViewById(R.id.p2PurpleBtn);
        ImageButton p2OrangeBtn = findViewById(R.id.p2OrangeBtn);
        ImageButton p2BrownBtn = findViewById(R.id.p2BrownBtn);

        //Below this will check if player 1 color was selected
        //Checks first to see if it was touched
        if (touchp1Red) {
            tmpColor = "#E91414";
            //Checks to see if player 2 picked same color
            if (player2Color == tmpColor) {
                //p1RedBtn.setImageResource(R.drawable.cantslt);
            } else {
                p1RedBtn.setImageResource(R.drawable.redslt);
                player1Color = "#E91414";

                selectCheck();
            }
        }

        //Checks first to see if it was touched
        if (touchp1Blue) {
            tmpColor = "#1443E9";
            //Checks to see if player 2 picked same color
            if (player2Color == tmpColor) {
            } else {
                p1BlueBtn.setImageResource(R.drawable.blueslt);
                player1Color = "#1443E9";

                selectCheck();
            }
        }

        //Checks first to see if it was touched
        if (touchp1Green) {
            tmpColor = "#32E914";
            //Checks to see if player 2 picked same color
            if (player2Color == tmpColor) {
            } else {
                p1GreenBtn.setImageResource(R.drawable.greenslt);
                player1Color = "#32E914";

                selectCheck();
            }
        }
        //Checks first to see if it was touched
        if (touchp1LightBlue) {
            tmpColor = "#14DCE9";
            //Checks to see if player 2 picked same color
            if (player2Color == tmpColor) {
            } else {
                p1LightBlueBtn.setImageResource(R.drawable.lightblueslt);
                player1Color = "#14DCE9";

                selectCheck();
            }
        }
        //Checks first to see if it was touched
        if (touchp1Purple) {
            tmpColor = "#CB14E9";
            //Checks to see if player 2 picked same color
            if (player2Color == tmpColor) {
            } else {
                p1PurpleBtn.setImageResource(R.drawable.purpleslt);
                player1Color = "#CB14E9";

                selectCheck();
            }
        }
        //Checks first to see if it was touched
        if (touchp1Orange) {
            tmpColor = "#E96E14";
            //Checks to see if player 2 picked same color
            if (player2Color == tmpColor) {
            } else {
                p1OrangeBtn.setImageResource(R.drawable.orangeslt);
                player1Color = "#E96E14";

                selectCheck();
            }
        }
        //Checks first to see if it was touched
        if (touchp1Brown) {
            tmpColor = "#932B2B";
            //Checks to see if player 2 picked same color
            if (player2Color == tmpColor) {
            } else {
                p1BrownBtn.setImageResource(R.drawable.brownslt);
                player1Color = "#932B2B";

                selectCheck();
            }
        }

        //Below this will check if player 2 color was selected
        //Checks first to see if it was touched
        if (touchp2Red) {
            tmpColor = "#E91414";
            //Checks to see if player 1 picked same color
            if (player1Color == tmpColor) {
            } else {
                p2RedBtn.setImageResource(R.drawable.redslt);
                player2Color = "#E91414";

                selectCheck();
            }
        }

        if (touchp2Blue) {
            tmpColor = "#1443E9";
            //Checks to see if player 1 picked same color
            if (player1Color == tmpColor) {
            } else {
                p2BlueBtn.setImageResource(R.drawable.blueslt);
                player2Color = "#1443E9";
                selectCheck();
            }
        }

        //Checks first to see if it was touched
        if (touchp2Green) {
            tmpColor = "#32E914";
            //Checks to see if player 2 picked same color
            if (player1Color == tmpColor) {
            } else {
                p2GreenBtn.setImageResource(R.drawable.greenslt);
                player2Color = "#32E914";
                selectCheck();
            }
        }
        //Checks first to see if it was touched
        if (touchp2LightBlue) {
            tmpColor = "#14DCE9";
            //Checks to see if player 2 picked same color
            if (player1Color == tmpColor) {
            } else {
                p2LightBlueBtn.setImageResource(R.drawable.lightblueslt);
                player2Color = "#14DCE9";
                selectCheck();
            }
        }
        //Checks first to see if it was touched
        if (touchp2Purple) {
            tmpColor = "#CB14E9";
            //Checks to see if player 2 picked same color
            if (player1Color == tmpColor) {
            } else {
                p2PurpleBtn.setImageResource(R.drawable.purpleslt);
                player2Color = "#CB14E9";
                selectCheck();
            }
        }
        //Checks first to see if it was touched
        if (touchp2Orange) {
            tmpColor = "#E96E14";
            //Checks to see if player 2 picked same color
            if (player1Color == tmpColor) {
            } else {
                p2OrangeBtn.setImageResource(R.drawable.orangeslt);
                player2Color = "#E96E14";
                selectCheck();
            }
        }
        //Checks first to see if it was touched
        if (touchp2Brown) {
            tmpColor = "#932B2B";
            //Checks to see if player 2 picked same color
            if (player1Color == tmpColor) {
            } else {
                p2BrownBtn.setImageResource(R.drawable.brownslt);
                player2Color = "#932B2B";
                selectCheck();
            }
        }

    }
    
    /*red "#E91414"
    blue "#1443E9"
    green "#32E914"
    lightblue "#14DCE9"
    purple "#CB14E9"
    orange "#E96E14"
    brown "#932B2B"
     */

    public void selectCheck() {
        ImageButton p1RedBtn = findViewById(R.id.p1RedBtn);
        ImageButton p1BlueBtn = findViewById(R.id.p1BlueBtn);
        ImageButton p1GreenBtn = findViewById(R.id.p1GreenBtn);
        ImageButton p1LightBlueBtn = findViewById(R.id.p1LightBlueBtn);
        ImageButton p1PurpleBtn = findViewById(R.id.p1PurpleBtn);
        ImageButton p1OrangeBtn = findViewById(R.id.p1OrangeBtn);
        ImageButton p1BrownBtn = findViewById(R.id.p1BrownBtn);

        ImageButton p2RedBtn = findViewById(R.id.p2RedBtn);
        ImageButton p2BlueBtn = findViewById(R.id.p2BlueBtn);
        ImageButton p2GreenBtn = findViewById(R.id.p2GreenBtn);
        ImageButton p2LightBlueBtn = findViewById(R.id.p2LightBlueBtn);
        ImageButton p2PurpleBtn = findViewById(R.id.p2PurpleBtn);
        ImageButton p2OrangeBtn = findViewById(R.id.p2OrangeBtn);
        ImageButton p2BrownBtn = findViewById(R.id.p2BrownBtn);

        //Player1
        if (player1Color == "#E91414") {
            //p1RedBtn.setImageResource(R.drawable.red);
            p1BlueBtn.setImageResource(R.drawable.blue);
            p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player1Color == "#1443E9") {
            p1RedBtn.setImageResource(R.drawable.red);
            //p1BlueBtn.setImageResource(R.drawable.blue);
            p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player1Color == "#32E914") {
            p1RedBtn.setImageResource(R.drawable.red);
            p1BlueBtn.setImageResource(R.drawable.blue);
            //p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player1Color == "#14DCE9") {
            p1RedBtn.setImageResource(R.drawable.red);
            p1BlueBtn.setImageResource(R.drawable.blue);
            p1GreenBtn.setImageResource(R.drawable.green);
            //p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player1Color == "#CB14E9") {
            p1RedBtn.setImageResource(R.drawable.red);
            p1BlueBtn.setImageResource(R.drawable.blue);
            p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            //p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player1Color == "#E96E14") {
            p1RedBtn.setImageResource(R.drawable.red);
            p1BlueBtn.setImageResource(R.drawable.blue);
            p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            //p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player1Color == "#932B2B") {
            p1RedBtn.setImageResource(R.drawable.red);
            p1BlueBtn.setImageResource(R.drawable.blue);
            p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            //p1BrownBtn.setImageResource(R.drawable.brown);
        }
        //Player2
        if (player2Color == "#E91414") {
            //p2RedBtn.setImageResource(R.drawable.red);
            p2BlueBtn.setImageResource(R.drawable.blue);
            p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player2Color == "#1443E9") {
            p2RedBtn.setImageResource(R.drawable.red);
            //p2BlueBtn.setImageResource(R.drawable.blue);
            p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player2Color == "#32E914") {
            p2RedBtn.setImageResource(R.drawable.red);
            p2BlueBtn.setImageResource(R.drawable.blue);
            //p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player2Color == "#14DCE9") {
            p2RedBtn.setImageResource(R.drawable.red);
            p2BlueBtn.setImageResource(R.drawable.blue);
            p2GreenBtn.setImageResource(R.drawable.green);
            //p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player2Color == "#CB14E9") {
            p2RedBtn.setImageResource(R.drawable.red);
            p2BlueBtn.setImageResource(R.drawable.blue);
            p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            //p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player2Color == "#E96E14") {
            p2RedBtn.setImageResource(R.drawable.red);
            p2BlueBtn.setImageResource(R.drawable.blue);
            p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            //p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
        if (player2Color == "#932B2B") {
            p2RedBtn.setImageResource(R.drawable.red);
            p2BlueBtn.setImageResource(R.drawable.blue);
            p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            //p2BrownBtn.setImageResource(R.drawable.brown);
        }
    }
}