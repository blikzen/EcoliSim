package info.androidhive.expandablelistview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.Random;
import java.util.jar.Attributes;

public class MySurfaceView extends SurfaceView {

    SurfaceHolder surfaceHolder;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Random random;

    public MySurfaceView(Context context, AttributeSet attr) {
        super(context,attr);
        surfaceHolder = getHolder();
        random = new Random();
    }

    public void clearlines(){

        if(surfaceHolder.getSurface().isValid()){
        Canvas canvas = surfaceHolder.lockCanvas();
        canvas.clear();
        surfaceHolder.unlockCanvasAndPost(canvas);}
    }
    public void plotlines(int selcolor,float fx,float fy, float sx, float sy){
        if(surfaceHolder.getSurface().isValid()){
            Canvas canvas = surfaceHolder.lockCanvas();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3);
            paint.setColor(selcolor);
            canvas.drawLine(fx, fy, sx, sy, paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}