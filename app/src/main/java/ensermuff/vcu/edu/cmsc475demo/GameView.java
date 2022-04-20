package ensermuff.vcu.edu.cmsc475demo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import ensermuff.vcu.edu.cmsc475demo.Activities.GameActivity;
import ensermuff.vcu.edu.cmsc475demo.Activities.SettingsActivity;

public class GameView extends View {

    Paint paint = new Paint();
    GameActivity activity;
    GameDataModel model;
    String player1, player2;
    ArrayList<Line> lines;
    ArrayList<Area> areas;
    Line lastLine;
    String player1Color = SettingsActivity.player1Color;
    String player2Color = SettingsActivity.player2Color;

//    ArrayList<GridPoint> p1 = new ArrayList<>();
//    ArrayList<GridPoint> p2 = new ArrayList<>();
//    ArrayList<LINE_TYPE> line_types = new ArrayList<>();


//    static GridPoint lastPoint;
//    static GridPoint lasttPoint2;
//    static LINE_TYPE lastLineType;

//    public static GridPoint getLastPoint() {
//        return lastPoint;
//    }
//    public static LINE_TYPE getLastLineType() {
//        return lastLineType;
//    }
//    public static GridPoint getLasttPoint2() {
//        return lasttPoint2;
//    }

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

        /*player1 = GameActivity.player1;
        player2 = GameActivity.player2;
        if (player1 == null) {
            player1 = "Player1";
        }
        if (player2 == null) {
            player2 = "Player2";
        }*/

        player1 = "Player1";
        player2 = "Player2";

        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(8);
        setMinimumHeight(100);
        this.setFocusableInTouchMode(true);


    }
    public GameDataModel getModel(){
        return model;
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

    public void onDraw(Canvas canvas) {
//        for(Area area : areas){
//            canvas.drawRect(area.getSquare(), area.getPaint());
//        }

        for (Area[] areas : model.getAreas()) {
            for (Area area : areas) {
                area.draw(canvas);
            }
        }
        /*
        try to add areas to the arraylist of type Area
         */
//        Area myArea = new Area();
//        if (myArea.getOwner() == 0)
//            paint.setColor(Color.WHITE);
//        else if (myArea.getOwner() == 1)
//            paint.setColor(Color.RED);
//        else if (myArea.getOwner() == 2)
//            paint.setColor(Color.BLUE);
//
//        for (Area[] myAreas: model.getAreas()){
//            for(Area area : myAreas){
//                areas.add(area);
////                area.draw(canvas);
//            }
//        }
//        for(int i = 0; i < areas.size(); i++){
//            canvas.drawRect(areas.get(i).getCenter().getX() - GameDataModel.getLENGTH(),
//                    areas.get(i).getCenter().getY() - GameDataModel.getLENGTH(),
//                    areas.get(i).getCenter().getX() + GameDataModel.getLENGTH(),
//                    areas.get(i).getCenter().getY() + GameDataModel.getLENGTH(),
//                    areas.get(i).getPaint());
//        }


        // adding lines to the arrayList of type Line
        for (Line line : model.getLines()) {
            lines.add(line);
        }
        for(int i = 0; i < lines.size(); i++){
            canvas.drawLine(lines.get(i).getP1().getX(), lines.get(i).getP1().getY(),
                    lines.get(i).getP2().getX(), lines.get(i).getP2().getY(), lines.get(i).getPaint());
        }

//        for (Line line : model.getLines()) {
//            line.draw(canvas);
//        }

        //Setting up dots (dots x and y coordinates are set up by 10?)
        for (GridPoint[] p_list : model.getGridPoints()) {
            for (GridPoint p : p_list) {
                paint.setColor(Color.BLACK);
                canvas.drawCircle((p.getX()-Line.WIDTH/2) + 10, (p.getY()-Line.WIDTH/2) + 10,20, paint);
            }
        }

        //Rectangles for background of text
        paint.setColor(Color.parseColor(player1Color));
        canvas.drawRect(0,0,700,200, paint);

        paint.setColor(Color.parseColor(player2Color));
        canvas.drawRect(740,0,1440,200, paint);


        paint.setTextSize(getWidth() / 10);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setColor(Color.WHITE);
        canvas.drawText("Player1: " + model.getPlayers()[0].getScore(), 0,125,paint);
        paint.setTextSize((int) (getWidth() / 10 * 1.2));
//        canvas.drawText(model.getPlayers()[0].getScore() + "", getWidth() / 10, getWidth() / 10 * 2, paint);

        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setColor(Color.WHITE);
        paint.setTextSize(getWidth() / 10);
        canvas.drawText("Player2: " + model.getPlayers()[1].getScore(), getWidth(),125,paint);
        paint.setTextSize((int) (getWidth() / 10 * 1.2));
//        canvas.drawText(model.getPlayers()[1].getScore() + "", getWidth() - getWidth() / 10, getWidth() / 10 * 2, paint);

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize((int) (getWidth() / 10 * 1.2));
        if (!model.checkGameOver()) {
            if (model.getTurn() % 2 == 0)
                paint.setColor(Color.parseColor(player1Color));
            else
                paint.setColor(Color.parseColor(player2Color));
            canvas.drawText("" + (model.getTurn() % 2 == 0 ? player1 : player2) + "'s Turn", getWidth() / 2, (int) (getWidth() / 10 * 3.5), paint);
        } else {
            activity.openWinningDialog();
            paint.setColor(Color.RED);
            paint.setTextSize((int) (getWidth() / 10 * 1.2));
            canvas.drawText("GAME OVER", getWidth() / 2, (int) (getWidth() / 10 * 3) + 25, paint);
            if (model.isDrawGame)
                canvas.drawText("DRAW", getWidth() / 2, (int) (getWidth() / 10 * 4), paint);
            else
                canvas.drawText("" + (model.getPlayers()[0].getScore() > model.getPlayers()[1].getScore() ? player1 : player2) + " WIN!!!", getWidth() / 2, (int) (getWidth() / 10 * 4), paint);

            paint.setColor(Color.BLACK);
//            canvas.drawText("RETRY??", getWidth()/2,getHeight() - getHeight()/12, paint);
            paint.setTextSize((int) (getWidth() / 10 * 0.6));
            canvas.drawText("Touch the screen to restart", getWidth() / 2, getHeight() - getHeight() / 24, paint);
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


