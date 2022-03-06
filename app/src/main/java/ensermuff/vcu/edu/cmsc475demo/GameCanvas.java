package ensermuff.vcu.edu.cmsc475demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GameCanvas extends View
{

    Paint paint;
    Rect rect;
    private int row;
    private int column;

    public GameCanvas(Context context){
        super(context);
        paint = new Paint();
        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(1);

        canvas.drawRect(300,300, 200, 200, paint);
        canvas.drawRect(1000,1000, 100, 100, paint);

        /*row = 300;
        column = 300;

        for (int i =0; i<row; i++){
            for (int j = 0; j<column; j++){

            }
        }*/



    }
}
