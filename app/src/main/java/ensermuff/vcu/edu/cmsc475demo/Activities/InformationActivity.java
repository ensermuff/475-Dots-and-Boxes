package ensermuff.vcu.edu.cmsc475demo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import ensermuff.vcu.edu.cmsc475demo.R;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ImageButton backBtn = findViewById(R.id.returnBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is an action being requested that the device should try to perform
                if(GameActivity.infoGame) {
                    Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(startIntent);
                }
                else if(!GameActivity.infoGame) {
                    Intent startIntent = new Intent(getApplicationContext(), GameActivity.class);
                    startActivity(startIntent);
                }
            }
        });
    }
}