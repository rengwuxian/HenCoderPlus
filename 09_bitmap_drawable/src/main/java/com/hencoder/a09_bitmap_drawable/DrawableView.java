package com.hencoder.a09_bitmap_drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawableView extends View {
    Drawable drawable;

    public DrawableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        drawable = new MeshDrawable();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawable.setBounds(100, 100, getWidth(), getHeight());
        drawable.draw(canvas);
    }
}
