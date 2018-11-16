package com.hencoder.a10_layout.view;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

public class SquareImageView extends androidx.appcompat.widget.AppCompatImageView {
    public SquareImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int size = Math.max(measuredWidth, measuredHeight);

        setMeasuredDimension(size, size); // 保存测得的尺寸
    }
}
