package ensermuff.vcu.edu.cmsc475demo.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import ensermuff.vcu.edu.cmsc475demo.GameDataModel;
import ensermuff.vcu.edu.cmsc475demo.GameView;
import ensermuff.vcu.edu.cmsc475demo.R;

public class SettingsActivity extends AppCompatActivity {

    public static String player1Color = "#E91414";
    public static String player2Color = "#1443E9";
    public static int gridSet = 5;
    GameView view;

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
        beforeColorCheck();

        //Sets the value of the player1 colors
        ImageButton p1RedBtn = findViewById(R.id.p1RedBtn);
        p1RedBtn.setOnClickListener((v) ->{

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
        p1BlueBtn.setOnClickListener((v) ->{

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
        p1GreenBtn.setOnClickListener((v) ->{

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
        p1LightBlueBtn.setOnClickListener((v) ->{
            player1Color = "#14DCE9";
        });

        ImageButton p1PurpleBtn = findViewById(R.id.p1PurpleBtn);
        p1PurpleBtn.setOnClickListener((v) ->{
            player1Color = "#CB14E9";
        });

        ImageButton p1OrangeBtn = findViewById(R.id.p1OrangeBtn);
        p1OrangeBtn.setOnClickListener((v) ->{
            player1Color = "#E96E14";
        });

        ImageButton p1BrownBtn = findViewById(R.id.p1BrownBtn);
        p1BrownBtn.setOnClickListener((v) ->{
            player1Color = "#932B2B";
        });

        //Sets the value of the player1 colors
        ImageButton p2RedBtn = findViewById(R.id.p2RedBtn);
        p2RedBtn.setOnClickListener((v) ->{

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
        p2BlueBtn.setOnClickListener((v) ->{

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
        p2GreenBtn.setOnClickListener((v) ->{

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
        p2LightBlueBtn.setOnClickListener((v) ->{
            player2Color = "#14DCE9";
        });

        ImageButton p2PurpleBtn = findViewById(R.id.p2PurpleBtn);
        p2PurpleBtn.setOnClickListener((v) ->{
            player2Color = "#CB14E9";
        });

        ImageButton p2OrangeBtn = findViewById(R.id.p2OrangeBtn);
        p2OrangeBtn.setOnClickListener((v) ->{
            player2Color = "#E96E14";
        });

        ImageButton p2BrownBtn = findViewById(R.id.p2BrownBtn);
        p2BrownBtn.setOnClickListener((v) ->{
            player2Color = "#932B2B";
        });

        //Sets the value of the grid
        Button grid6x6 = findViewById(R.id.btn6x6);
        grid6x6.setOnClickListener((v) ->{
            gridSet = 5;
            GameDataModel.GRID = gridSet;
        });

        Button grid5x5 = findViewById(R.id.btn5x5);
        grid5x5.setOnClickListener((v) ->{
            gridSet = 4;
            GameDataModel.GRID = gridSet;
        });

        Button grid4x4 = findViewById(R.id.btn4x4);
        grid4x4.setOnClickListener((v) ->{
            gridSet = 3;
            GameDataModel.GRID = gridSet;
        });

    }

    private void beforeColorCheck() {
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

        p1RedBtn.setImageResource(R.drawable.redslt);
        p1BlueBtn.setImageResource(R.drawable.cantslt);
        p2RedBtn.setImageResource(R.drawable.cantslt);
        p2BlueBtn.setImageResource(R.drawable.blueslt);
    }

    public void colorCheck(){
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

        String tmpColor;

        //Below this will check if player 1 color was selected
        //Checks first to see if it was touched
        if(touchp1Red) {
            tmpColor = "#E91414";
            //Checks to see if player 2 picked same color
            if(tmpColor == player2Color){
                p1RedBtn.setImageResource(R.drawable.cantslt);
            }
            else{
                p1RedBtn.setImageResource(R.drawable.redslt);
                p2RedBtn.setImageResource(R.drawable.cantslt);
                player1Color = "#E91414";
                
                selectCheck();
            }
        }

        //Checks first to see if it was touched
        if(touchp1Blue) {
            tmpColor = "#1443E9";
            //Checks to see if player 2 picked same color
            if(tmpColor == player2Color){
                p1BlueBtn.setImageResource(R.drawable.cantslt);
            }
            else{
                p1BlueBtn.setImageResource(R.drawable.blueslt);
                p2BlueBtn.setImageResource(R.drawable.cantslt);
                player1Color = "#1443E9";

                selectCheck();
            }
        }

        //Checks first to see if it was touched
        if(touchp1Green) {
            tmpColor = "#32E914";
            //Checks to see if player 2 picked same color
            if(tmpColor == player2Color){
                p1GreenBtn.setImageResource(R.drawable.cantslt);
            }
            else{
                p1GreenBtn.setImageResource(R.drawable.greenslt);
                p2GreenBtn.setImageResource(R.drawable.cantslt);
                player1Color = "#32E914";

                selectCheck();
            }
        }

        //Below this will check if player 2 color was selected
        //Checks first to see if it was touched
        if(touchp2Red) {
            tmpColor = "#E91414";
            //Checks to see if player 1 picked same color
            if(tmpColor == player1Color){
                p2RedBtn.setImageResource(R.drawable.cantslt);
            }
            else{
                p2RedBtn.setImageResource(R.drawable.redslt);
                p1RedBtn.setImageResource(R.drawable.cantslt);
                player2Color = "#E91414";

                selectCheck();
            }
        }

        if(touchp2Blue) {
            tmpColor = "#1443E9";
            //Checks to see if player 1 picked same color
            if(tmpColor == player1Color){
                p2BlueBtn.setImageResource(R.drawable.cantslt);
            }
            else{
                p2BlueBtn.setImageResource(R.drawable.blueslt);
                p1BlueBtn.setImageResource(R.drawable.cantslt);
                player2Color = "#1443E9";

                selectCheck();
            }
        }

        //Checks first to see if it was touched
        if(touchp2Green) {
            tmpColor = "#32E914";
            //Checks to see if player 2 picked same color
            if(tmpColor == player1Color){
                p1GreenBtn.setImageResource(R.drawable.cantslt);
            }
            else{
                p2GreenBtn.setImageResource(R.drawable.greenslt);
                p1GreenBtn.setImageResource(R.drawable.cantslt);
                player2Color = "#32E914";

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
    
    public void selectCheck(){
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
        
        if(player1Color == "#E91414"){
            //p1RedBtn.setImageResource(R.drawable.red);
            p1BlueBtn.setImageResource(R.drawable.blue);
            p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        else if(player1Color == "#1443E9"){
            p1RedBtn.setImageResource(R.drawable.red);
            //p1BlueBtn.setImageResource(R.drawable.blue);
            p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        else if(player1Color == "#32E914"){
            p1RedBtn.setImageResource(R.drawable.red);
            p1BlueBtn.setImageResource(R.drawable.blue);
            //p1GreenBtn.setImageResource(R.drawable.green);
            p1LightBlueBtn.setImageResource(R.drawable.lightblue);
            p1PurpleBtn.setImageResource(R.drawable.purple);
            p1OrangeBtn.setImageResource(R.drawable.orange);
            p1BrownBtn.setImageResource(R.drawable.brown);
        }
        else if(player2Color == "#E91414"){
            //p2RedBtn.setImageResource(R.drawable.red);
            p2BlueBtn.setImageResource(R.drawable.blue);
            p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
        else if(player1Color == "#1443E9"){
            p2RedBtn.setImageResource(R.drawable.red);
            //p2BlueBtn.setImageResource(R.drawable.blue);
            p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
        else if(player1Color == "#32E914"){
            p2RedBtn.setImageResource(R.drawable.red);
            p2BlueBtn.setImageResource(R.drawable.blue);
            //p2GreenBtn.setImageResource(R.drawable.green);
            p2LightBlueBtn.setImageResource(R.drawable.lightblue);
            p2PurpleBtn.setImageResource(R.drawable.purple);
            p2OrangeBtn.setImageResource(R.drawable.orange);
            p2BrownBtn.setImageResource(R.drawable.brown);
        }
    }
}
