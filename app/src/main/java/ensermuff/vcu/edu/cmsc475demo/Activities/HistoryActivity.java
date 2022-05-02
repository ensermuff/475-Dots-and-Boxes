package ensermuff.vcu.edu.cmsc475demo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import ensermuff.vcu.edu.cmsc475demo.R;

public class HistoryActivity extends AppCompatActivity {

    public ArrayList<String> historyList;
    ArrayAdapter arrayAdapter;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        ImageButton backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent is an action being requested that the device should try to perform
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity() is used to launch another activity
                startActivity(startIntent);
            }
        });

        listView = findViewById(R.id.listHistory);
        GameActivity.historyList = new ArrayList<>();

        //GameActivity.historyList.add("1 4");
        //listView.setAdapter(arrayAdapter);
        historyList = new ArrayList<>();
        historyList.add(String.valueOf(GameActivity.historyList));

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, historyList);
        listView.setAdapter(arrayAdapter);
    }

    public static void addHistory(String history){

        GameActivity.historyList.add(history);

    }
}