package ensermuff.vcu.edu.cmsc475demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView firstImage = (ImageView) findViewById(R.id.SquaresLogo);
        int imageResource = getResources().getIdentifier("@drawable/squares", null,this.getPackageName());
        firstImage.setImageResource(imageResource);

        ImageView secondImage = (ImageView) findViewById(R.id.Vcu);
        int imageResource2 = getResources().getIdentifier("@drawable/vcu", null,this.getPackageName());
        secondImage.setImageResource(imageResource2);


    }
}