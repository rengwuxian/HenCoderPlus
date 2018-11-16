package com.hencoder.a08_animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a08_animation.Utils;

public class ProvinceView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    String province = "北京市";

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
        invalidate();
    }

    public ProvinceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
//        setLayerType(LAYER_TYPE_SOFTWARE, null);
        setLayerType(LAYER_TYPE_HARDWARE, null);
//        setLayerType(LAYER_TYPE_NONE, null);
        paint.setTextSize(Utils.dpToPixel(60));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(province, getWidth() / 2, getHeight() / 2, paint);
    }
}
