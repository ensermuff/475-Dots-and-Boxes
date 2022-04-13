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
import ensermuff.vcu.edu.cmsc475demo.R;

public class SettingsActivity extends AppCompatActivity {

    public static String player1Color = "#fc4e42";;
    public static String player2Color = "#00abff";
    public static int gridSet = 5;


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

        //Sets the value of the player colors
        Button p1RedBtn = findViewById(R.id.p1RedBtn);
        p1RedBtn.setOnClickListener((v) ->{
            player1Color = "#fc4e42";
        });

        Button p1BlueBtn = findViewById(R.id.p1BlueBtn);
        p1BlueBtn.setOnClickListener((v) ->{
            player1Color = "#00abff";
        });

        Button p2RedBtn = findViewById(R.id.p2RedBtn);
        p2RedBtn.setOnClickListener((v) ->{
            player2Color = "#fc4e42";
        });

        Button p2BlueBtn = findViewById(R.id.p2BlueBtn);
        p2BlueBtn.setOnClickListener((v) ->{
            player2Color = "#00abff";
        });

        //Sets the value of the grid
        Button grid6x6 = findViewById(R.id.btn6x6);
        grid6x6.setOnClickListener((v) ->{
            gridSet = 5;
            GameDataModel.init(gridSet);
        });

        Button grid5x5 = findViewById(R.id.btn5x5);
        grid5x5.setOnClickListener((v) ->{
            gridSet = 4;
            GameDataModel.init(gridSet);
        });

        Button grid4x4 = findViewById(R.id.btn4x4);
        grid4x4.setOnClickListener((v) ->{
            gridSet = 3;
            GameDataModel.init(gridSet);
        });

    }
}
