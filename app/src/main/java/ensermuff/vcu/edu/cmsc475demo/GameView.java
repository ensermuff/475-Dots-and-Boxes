package ensermuff.vcu.edu.cmsc475demo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import ensermuff.vcu.edu.cmsc475demo.Activities.GameActivity;
import ensermuff.vcu.edu.cmsc475demo.Activities.SettingsActivity;

public class GameView extends View {

    public static String winner;
    Paint paint = new Paint();
    GameActivity activity;
    GameDataModel model;
    String player1, player2;
    ArrayList<Line> lines;
    ArrayList<Area> areas;
    Line lastLine;
    String player1Color = SettingsActivity.player1Color;
    String player2Color = SettingsActivity.player2Color;
    MediaPlayer clickSounds;


    public GameView(Context context, GameDataModel model) {
        super(context);
        this.model = model;

        activity = (GameActivity) getActivity();

        lines = new ArrayList<>();
        areas = new ArrayList<>();

        //set game screen to fullscreen, have to cast to Activity since getWindow() doesn't work on a custom view
        View decorView = ((Activity)getContext()).getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        /*Typeface face = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            face = (getContext().getResources().getFont(R.font.syncopate_bold));
            ((TextView)decorView).setTypeface(face);
        }*/


        /*player1 = GameActivity.player1;
        player2 = GameActivity.player2;
        if (player1 == null) {
            player1 = "Player1";
        }
        if (player2 == null) {
            player2 = "Player2";
        }*/

        player1 = "Player 1";
        player2 = "Player 2";

        //paint.setColor(Color.WHITE);
        paint.setStrokeWidth(8);
        setMinimumHeight(100);
        this.setFocusableInTouchMode(true);
        clickSounds = MediaPlayer.create(getContext(), R.raw.mixkit_interface_click_1126);


    }

    // doesn't work yet
    public void undo(){
        //lastline is assigned a line on the onTouchEvent method
        for (Line line : model.getLines()){
            if (line == lastLine){
                Paint myPaint = new Paint();
                myPaint.setColor(Color.LTGRAY);  //change the line color back to light gray
                line.setDraw(false);
                lines.remove(line);
                model.turnover(); //need to fix this
                line.setColor("lightGrey");
                GameDataModel.init2(model.getAreas(),lines, model.getTurn(), model.getPlayers()[0].getScore(), model.getPlayers()[1].getScore());
                invalidate(); //redraw
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onDraw(Canvas canvas) {
        for (Area[] areas : model.getAreas()) {
            for (Area area : areas) {
                area.draw(canvas);
            }
        }

        // adding lines to the arrayList of type Line
        for (Line line : model.getLines()) {
            lines.add(line);
        }
        for(int i = 0; i < lines.size(); i++){
            canvas.drawLine(lines.get(i).getP1().getX(), lines.get(i).getP1().getY(),
                    lines.get(i).getP2().getX(), lines.get(i).getP2().getY(), lines.get(i).getPaint());
        }

        //Setting up dots (dots x and y coordinates are set up by 10?)
        for (GridPoint[] p_list : model.getGridPoints()) {
            for (GridPoint p : p_list) {
                paint.setColor(Color.BLACK);
                canvas.drawCircle((p.getX()-Line.WIDTH/2) + 10, (p.getY()-Line.WIDTH/2) + 10,35, paint);
            }
        }
        activity.setPlayerNames();

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize((int) (getWidth() / 10 * 1.2));
        if (!model.checkGameOver()) {
            if (model.getTurn() % 2 == 0)
                paint.setColor(Color.parseColor(player1Color));
            else
                paint.setColor(Color.parseColor(player2Color));
            String myTurn = model.getTurn() % 2 == 0 ? SettingsActivity.player1Name + "'s Turn": SettingsActivity.player2Name + "'s Turn";
            activity.setTurn(myTurn);
        } else {
            activity.openWinningDialog();
            paint.setColor(Color.RED);
            paint.setTextSize((int) (getWidth() / 10 * 1.2));

            String winningText;
            if (model.isDrawGame){
                winningText = "Draw Game\n Touch Screen to Continue";
                activity.setGameOver(winningText);
            } else {
                if(model.getPlayers()[0].getScore() > model.getPlayers()[1].getScore()){
                    winningText = SettingsActivity.player1Name + " Wins!";
                    activity.setGameOver(winningText);
                } else {
                    winningText = SettingsActivity.player2Name + " Wins!";
                    activity.setGameOver(winningText);

                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();
        Line touchLine = null;
        boolean isClickedLine = false;

        if (!model.checkGameOver()) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    for (Line line : model.getLines()) {
                        touchLine = line;
                        if (line.getLINE_TYPE() == LINE_TYPE.HORIZONTAL) {
                            if (currentX > line.getP1().getX() && currentX < line.getP2().getX()
                                    && currentY > line.getP1().getY() - Line.WIDTH && currentY < line.getP2().getY() + Line.WIDTH) {

                                if (line.getDraw() == true)
                                    return false;

                                //Player 1 RED and Player 2 BLUE
                                //Checking the Horizontal Lines
                                if(model.getTurn() % 2 == 0){
                                    //line.getPaint().setColor(Color.RED);
                                    line.getPaint().setColor(Color.parseColor(player1Color));
                                }else {
                                    line.getPaint().setColor(Color.parseColor(player2Color));

                                }
                                lastLine = line;
                                line.setDraw(true);
                                isClickedLine = true;
                                if(SettingsActivity.sounds){
                                    clickSounds.start();
                                }
                                Log.d("ddamddi", " [LINE]" +
                                        " (" + (line.getP1().getX() - GameDataModel.getxMin())
                                        / GameDataModel.getLENGTH() + "," + (line.getP1().getY() -
                                        GameDataModel.getyMin()) / GameDataModel.getLENGTH() +
                                        ")-(" + (line.getP2().getX() - GameDataModel.getxMin()) /
                                        GameDataModel.getLENGTH() + "," + (line.getP2().getY() -
                                        GameDataModel.getyMin()) / GameDataModel.getLENGTH() + ") is Drawn");
                                break;
                            }
                        }
                        else {
                            if (currentX > line.getP1().getX() - Line.WIDTH && currentX < line.getP2().getX() + Line.WIDTH
                                    && currentY > line.getP1().getY() && currentY < line.getP2().getY()) {

                                if (line.getDraw() == true)
                                    return false;

                                //Player 1 RED and Player 2 BLUE
                                //Checking the Vertical lines
                                if (model.getTurn() % 2 == 0) {
                                    line.getPaint().setColor(Color.parseColor(player1Color));
                                }else {
                                    line.getPaint().setColor(Color.parseColor(player2Color));
                                }
                                lastLine = line;
                                line.setDraw(true);
                                isClickedLine = true;
                                if(SettingsActivity.sounds){
                                    clickSounds.start();
                                }
                                Log.d("ddamddi", " [LINE]   (" + (line.getP1().getX() - GameDataModel.getxMin()) / GameDataModel.getLENGTH() + "," + (line.getP1().getY() - GameDataModel.getyMin()) / GameDataModel.getLENGTH() + ")-(" + (line.getP2().getX() - GameDataModel.getxMin()) / GameDataModel.getLENGTH() + "," + (line.getP2().getY() - GameDataModel.getyMin()) / GameDataModel.getLENGTH() + ") is Drawn");
                                break;
                            }
                        }   // LINE_TYPE.VERTICAL
                    }
                    if (!isClickedLine)
                        return false;

                    if (!model.checkArea(touchLine))
                        model.turnover();

                    if (model.checkGameOver()) {
                        for (int x = 0; x < 10; ++x)
                            Log.d("ddamddi", "[GAME OVER]");
                    }
                    invalidate();
                    break;
            }
        } else {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    model.init();
                    invalidate();
                    break;
            }
        }
        return true;
    }

    public Activity getActivity() {
        Context context = getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

}


