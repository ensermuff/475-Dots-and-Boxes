package ensermuff.vcu.edu.cmsc475demo.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ensermuff.vcu.edu.cmsc475demo.R;

public class HistoryActivity extends AppCompatActivity {
    ArrayAdapter arrayAdapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ImageButton backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(view -> {
            // Intent is an action being requested that the device should try to perform
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            //startActivity() is used to launch another activity
            startActivity(startIntent);
        });

        listView = findViewById(R.id.listHistory);

        //getApplicationContext()
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, GameActivity.historyList){

        @SuppressLint("ResourceType")
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            // Get the current item from ListView
            View view = super.getView(position,convertView,parent);
            if(position %2 == 1)
            {
                // Set a background color for ListView regular row/item
                view.setBackgroundColor(Color.parseColor("#BF82C9"));
                TextView ListItemShow = view.findViewById(android.R.id.text1);

                Typeface face = (getContext().getResources().getFont(R.font.syncopate_bold));
                ListItemShow.setTypeface(face);
                ListItemShow.setTextColor(Color.parseColor("#ffffff"));
                ListItemShow.setTextSize(20);
                ListItemShow.setGravity(Gravity.CENTER);
            }
            else
            {
                // Set the background color for alternate row/item
                view.setBackgroundColor(Color.parseColor("#AF4AC3"));
                TextView ListItemShow = view.findViewById(android.R.id.text1);

                Typeface face = (getContext().getResources().getFont(R.font.syncopate_bold));
                ListItemShow.setTypeface(face);
                ListItemShow.setTextColor(Color.parseColor("#ffffff"));
                ListItemShow.setTextSize(20);
                ListItemShow.setGravity(Gravity.CENTER);
            }
            return view;
        }
    };
        listView.setAdapter(arrayAdapter);
    }
    public static void removeHistory(String history){
        GameActivity.historyList.remove(0);
        GameActivity.historyList.add(history);
    }
    public static void addHistory(String history){
        GameActivity.historyList.add(history);
    }
    public ArrayAdapter getArrayAdapter() {
        return arrayAdapter;
    }
    public ListView getListView() {
        return listView;
    }

}