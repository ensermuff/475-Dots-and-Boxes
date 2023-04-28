package ensermuff.vcu.edu.cmsc475demo.Activities;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

public class HistoryActivityTest {
    private HistoryActivity myHistoryActivity;
    private ArrayList<String> historyList;

    @Before
    public void setUpHistoryActivity(){
        myHistoryActivity = new HistoryActivity();
        historyList = new ArrayList<>();
        historyList.add("player1:0 vs. player2:5");
        historyList.add("player1:3 vs. player2:5");
//        myHistoryActivity.historyList = historyList;
    }
    @Test
    public void testAddHistory(){
        String history = "Test history";
//        int initialSize = myHistoryActivity.historyList.size();
    }
    @Test
    public void testRemoveHistory(){

    }
}
