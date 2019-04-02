package com.cjh.sample.androiddemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TouchButton mTouchBtn1;
    private EditText mEditText;


    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int btn_touch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*test01分支测试修改*/
        /*继续修改test01分支*/
        /*测试test02分支*/
        mEditText = (EditText) findViewById(R.id.edit_et);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        initView();
    }

    public void initView() {
        mTouchBtn1 = (TouchButton) findViewById(R.id.btn_touch);
        mTouchBtn1.setVisibility(View.VISIBLE);



        List<Object> list = new ArrayList<>();

        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "click");
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

        mEditText.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ldl", "focused = " + mEditText.isFocused());
                InputMethodManager imm= (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                boolean success = imm.showSoftInput(mEditText, 0);
                Log.i("ldl", "show = " + success);
                mEditText.setText("haha");
            }
        }, 200);
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
