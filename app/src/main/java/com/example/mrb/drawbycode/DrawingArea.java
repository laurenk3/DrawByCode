package com.example.mrb.drawbycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mrb on 16-04-26.
 */
public class DrawingArea extends View // You need to extend the View class
{

    Paint pntTextPaint;     // Painting object to handle the paint jobs for graphics
    Paint pntGraphicsPaint;
    Paint pntGraphicsPaintWhite;// Painting object to handle the paint jobs for text
   // Path drawPath = new Path();
    //Canvas drawCanvas = new Canvas();


    boolean blnShowText;
    int intTextPosition;

    public DrawingArea(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawingArea,
                0, 0);

        try {
            blnShowText = a.getBoolean(R.styleable.DrawingArea_displayText, false);
            intTextPosition = a.getInteger(R.styleable.DrawingArea_labelPosition, 0);
        } finally {
            a.recycle();
        }

        init(); // Calling the init() method happens once, when we set up our Paint objects
    }

    private void init() {
        // This method is called once when the DrawingArea object is made.
        // It is best practice to handle the set-up of our Paint objects here rather than in onDraw()

        pntTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntGraphicsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntGraphicsPaintWhite =  new Paint(Paint.ANTI_ALIAS_FLAG);

        pntGraphicsPaint.setColor(Color.BLACK);
        pntGraphicsPaint.setStrokeWidth(3);
        pntGraphicsPaintWhite.setColor(Color.WHITE);


    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // This method exists to handle re-drawing of the DrawingArea object in the event of a
        //   resize of our App. For example, tilting the device may require us to redraw our content.
        // More instructions are meant to be added at the bottom if required.

        super.onSizeChanged(w, h, oldw, oldh);

    }

    protected void onDraw(Canvas canvas) {

        // This method is where we issue our actual drawing commands.
        // The Canvas parameter is what we draw ON; the Paint objects defined above are what we draw WITH.

        super.onDraw(canvas);

        canvas.drawCircle((float) 350.0, (float) 150.0, (float) 150.0, pntGraphicsPaint);
        canvas.drawCircle((float) 350.0, (float) 150.0, (float) 135.0, pntGraphicsPaintWhite);
        canvas.drawLine((float) 350.0, (float) -100.0, (float) 350.0, (float) 660.0, pntGraphicsPaint);//body
        canvas.drawLine((float) 660.0, (float) 350.0, (float) -100.0, (float) 350.0, pntGraphicsPaint);//arms
        canvas.drawLine((float) 350.0, (float) 650.0, (float) 1009.0, (float) 999.0, pntGraphicsPaint);//right leg
        canvas.drawLine((float) 350.0, (float) 650.0, (float) -100.0, (float) 999.0, pntGraphicsPaint);//left legdone
    }

    //public boolean onTouchEvent(MotionEvent event) {
        //float touchX = event.getX();
        //float touchY = event.getY();

        //switch (event.getAction()) {
            //case MotionEvent.ACTION_DOWN:
                //drawPath.moveTo(touchX, touchY);
                //break;
            //case MotionEvent.ACTION_MOVE:
                //drawPath.lineTo(touchX, touchY);
                //break;
            //case MotionEvent.ACTION_UP:
                //drawCanvas.drawPath(drawPath, pntTextPaint);
                //drawPath.reset();
                //break;
            //default:
                //return false;


        //}

        //{
            //invalidate();
           // return true;
        //}
    }





