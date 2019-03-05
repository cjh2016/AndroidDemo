package com.cjh.sample.androiddemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    public TouchButton mTouchBtn1;


    public int mTow;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*test01分支测试修改*/
        /*继续修改test01分支*/
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        initView();
    }

    private void initView() {
        mTouchBtn1 = (TouchButton) findViewById(R.id.btn_touch);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        //mTouchBtn.getHitRect(rect);
        mTouchBtn1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Rect rect = new Rect();
                mTouchBtn1.getHitRect(rect);
                Log.i("cjh", "getHitRect = [" + rect.left + ", " + rect.top + ", "
                        + rect.right + ", " + rect.bottom + "]");
            }
        }, 0);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("cjh", "activity dispatchTouchEvent ev = "  +ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("cjh", "activity onTouchEvent");
        logName();
        method();
        return super.onTouchEvent(event);
    }

    private void logName() {
        getName();
    }

    private void getName() {
        Log.i("cjh ", "getName here");
    }

    public  void method() {
        Log.i("cjh ", "getName here 1");
        paint.setColor(Color.RED);
        Log.i("cjh ", "getName here 2");
    }

}
