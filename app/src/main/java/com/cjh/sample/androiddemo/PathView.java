package com.cjh.sample.androiddemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by cjh on 18-11-7.
 */
public class PathView extends View implements View.OnClickListener {

    Path mPath;

    Paint mPaint;

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        // 为了方便观察,平移坐标系
        canvas.translate(300, 300);

        mPaint.setStyle(Paint.Style.FILL);

        Path path1 = new Path();
        Path path2 = new Path();

        // 画两个圆
        // 圆1:圆心 = (0,0),半径 = 100
        // 圆2:圆心 = (50,0),半径 = 100
        path1.addCircle(0, 0, 100, Path.Direction.CW);
        path2.addCircle(50, 0,100, Path.Direction.CW);

        // 取两个路径的异或集
        path1.op(path2, Path.Op.INTERSECT);
        // 画出路径
        canvas.drawPath(path1, mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int wrapContentWidth = 100, wrapContentHeight = 200;
        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT
                && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(wrapContentWidth, wrapContentHeight);
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(wrapContentWidth, heightSize);
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, wrapContentHeight);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public void onClick(View v) {
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(getContext(),
                R.anim.scale);
        AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(getContext(),
                R.anim.alpha);
        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(getContext(),
                R.anim.rotate);
        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(
                getContext(), R.anim.translate);
        AnimationSet setAnimation = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.set);

        startAnimation(translateAnimation);

        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setInterpolator(new LinearInterpolator());

    }
}
