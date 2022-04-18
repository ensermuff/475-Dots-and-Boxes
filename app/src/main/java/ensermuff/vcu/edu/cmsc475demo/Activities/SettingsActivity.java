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

    public static String player1Color = "#fc4e42";;
    public static String player2Color = "#00abff";
    public static int gridSet = 5;
    GameView view;


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

        //Sets the value of the player1 colors
        ImageButton p1RedBtn = findViewById(R.id.p1RedBtn);
        p1RedBtn.setOnClickListener((v) ->{
            player1Color = "#E91414";
        });

        ImageButton p1BlueBtn = findViewById(R.id.p1BlueBtn);
        p1BlueBtn.setOnClickListener((v) ->{
            player1Color = "#1443E9";
        });

        ImageButton p1GreenBtn = findViewById(R.id.p1GreenBtn);
        p1GreenBtn.setOnClickListener((v) ->{
            player1Color = "#32E914";
        });

        ImageButton p1LightBBtn = findViewById(R.id.p1LightBlueBtn);
        p1LightBBtn.setOnClickListener((v) ->{
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
            player2Color = "#E91414";
        });

        ImageButton p2BlueBtn = findViewById(R.id.p2BlueBtn);
        p2BlueBtn.setOnClickListener((v) ->{
            player2Color = "#1443E9";
        });

        ImageButton p2GreenBtn = findViewById(R.id.p2GreenBtn);
        p2GreenBtn.setOnClickListener((v) ->{
            player2Color = "#32E914";
        });

        ImageButton p2LightBBtn = findViewById(R.id.p2LightBlueBtn);
        p2LightBBtn.setOnClickListener((v) ->{
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
}
