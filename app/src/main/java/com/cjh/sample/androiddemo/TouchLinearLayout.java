package com.cjh.sample.androiddemo;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by cjh on 18-11-6.
 */

public class TouchLinearLayout extends LinearLayout {

    TextView mTextView;

    public TouchLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("cjh", "LinearLayout dispatchTouchEvent firstTouchView = " + getFirstTouchTarget());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("cjh", "LinearLayout onInterceptTouchEvent");
        /*if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            return true;
        }*/
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("cjh", "LinearLayout onTouchEvent");
        return false;
    }


    public Object getFirstTouchTarget() {
        Class clazz = ViewGroup.class;
        try {
            Field filed = clazz.getDeclaredField("mFirstTouchTarget");
            filed.setAccessible(true);
            return filed.get(this);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("cjh", "LinearLayout onDraw");

        super.onDraw(canvas);
    }
}
