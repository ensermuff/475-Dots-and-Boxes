package ensermuff.vcu.edu.cmsc475demo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import ensermuff.vcu.edu.cmsc475demo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView firstImage = findViewById(R.id.SquaresLogo);
        int imageResource = getResources().getIdentifier("@drawable/squares", null,this.getPackageName());
        firstImage.setImageResource(imageResource);

        ImageView secondImage = findViewById(R.id.Vcu);
        int imageResource2 = getResources().getIdentifier("@drawable/vcu", null,this.getPackageName());
        secondImage.setImageResource(imageResource2);

        ImageButton playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is an action being requested that the device should try to perform
                Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
                //startActivity() is used to launch another activity
                startActivity(startIntent);
            }
        });

        ImageButton infoBtn = findViewById(R.id.infoBtn);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is an action being requested that the device should try to perform
                Intent startIntent = new Intent(getApplicationContext(), InformationActivity.class);
                //startActivity() is used to launch another activity
                startActivity(startIntent);
            }
        });

        ImageButton settingsBtn = findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is an action being requested that the device should try to perform
                Intent startIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                //startActivity() is used to launch another activity
                startActivity(startIntent);
            }
        });

        ImageButton historyBtn = findViewById(R.id.historyBtn);
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is an action being requested that the device should try to perform
                Intent startIntent = new Intent(getApplicationContext(), HistoryActivity.class);
                //startActivity() is used to launch another activity
                startActivity(startIntent);
            }
        });
    }
}