package com.hencoder.a10_layout.view;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class OneHundredView extends View {
    public OneHundredView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(100, 100);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, l + 100, t + 100);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
