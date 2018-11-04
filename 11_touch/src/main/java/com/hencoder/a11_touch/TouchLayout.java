package com.hencoder.a11_touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class TouchLayout extends ViewGroup {
    public TouchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /*@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int delta = ev.getY()??????; // 纵向移动距离
        if (Math.abs(delta) > SLOP) {
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // saklfslkjfsldkjf
    }
}
