package ensermuff.vcu.edu.cmsc475demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ensermuff.vcu.edu.cmsc475demo.Activities.GameActivity;

public class GameView extends View {

    Paint paint = new Paint();
    GameDataModel model;
    String player1, player2;

    public GameView(Context context, GameDataModel model) {
        super(context);
        this.model = model;

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

    public void onDraw(Canvas canvas) {

        for (Area[] areas : model.getAreas()) {
            for (Area area : areas) {
                area.draw(canvas);
            }
        }

        for (Line line : model.getLines()) {
            line.draw(canvas);
        }

        //Setting up dots (dots x and y coordinates are set up by 10?)
        for (GridPoint[] p_list : model.getGridPoints()) {
            for (GridPoint p : p_list) {
                paint.setColor(Color.BLACK);
                canvas.drawCircle((p.getX()-Line.WIDTH/2) + 10, (p.getY()-Line.WIDTH/2) + 10,20, paint);
            }
        }

        //Rectangles for background of text
        paint.setColor(Color.RED);
        canvas.drawRect(0,0,700,200, paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(800,0,1600,200, paint);


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
                paint.setColor(Color.RED);
            else
                paint.setColor(Color.BLUE);
            canvas.drawText("" + (model.getTurn() % 2 == 0 ? player1 : player2) + "'s Turn", getWidth() / 2, (int) (getWidth() / 10 * 3.5), paint);
        } else {
            paint.setColor(Color.RED);
            paint.setTextSize((int) (getWidth() / 10 * 1.2));
            canvas.drawText("GAME OVER", getWidth() / 2, (int) (getWidth() / 10 * 3), paint);
            if (model.isDrawGame)
                canvas.drawText("DRAW", getWidth() / 2, (int) (getWidth() / 10 * 4), paint);
            else
                canvas.drawText("" + (model.getPlayers()[0].getScore() > model.getPlayers()[1].getScore() ? player1 : player2) + " WIN!!!", getWidth() / 2, (int) (getWidth() / 10 * 4), paint);

            paint.setColor(Color.BLACK);
//            canvas.drawText("RETRY??", getWidth()/2,getHeight() - getHeight()/12, paint);
            paint.setTextSize((int) (getWidth() / 10 * 0.6));
            canvas.drawText("Touch the screen to restart", getWidth() / 2, getHeight() - getHeight() / 24, paint);
        }
        /*
        messing around with creating a button
            Button mybutton = new Button();
            mybutton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            GameView.addView(mybutton);

         */
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
                                    line.getPaint().setColor(Color.RED);
                                }else {
                                    line.getPaint().setColor(Color.BLUE);

                                }
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
                                    line.getPaint().setColor(Color.RED);

                                }else {
                                    line.getPaint().setColor(Color.BLUE);

                                }
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


}

