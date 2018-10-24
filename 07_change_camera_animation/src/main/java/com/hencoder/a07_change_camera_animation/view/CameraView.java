package com.hencoder.a07_change_camera_animation.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.a07_change_camera_animation.Utils;

public class CameraView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Camera camera = new Camera();

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        camera.rotateX(45);
        camera.setLocation(0, 0, Utils.getZForCamera()); // -8 = -8 * 72
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制上半部分
        canvas.save();
        canvas.translate(100 + 600 / 2, 100 + 600 / 2);
        canvas.rotate(-20);
        canvas.clipRect(- 600, - 600, 600, 0);
        canvas.rotate(20);
        canvas.translate(- (100 + 600 / 2), - (100 + 600 / 2));
        canvas.drawBitmap(Utils.getAvatar(getResources(), 600), 100, 100, paint);
        canvas.restore();

        // 绘制下半部分
        canvas.save();
        canvas.translate(100 + 600 / 2, 100 + 600 / 2);
        canvas.rotate(-20);
        camera.applyToCanvas(canvas);
        canvas.clipRect(- 600, 0, 600, 600);
        canvas.rotate(20);
        canvas.translate(- (100 + 600 / 2), - (100 + 600 / 2));
        canvas.drawBitmap(Utils.getAvatar(getResources(), 600), 100, 100, paint);
        canvas.restore();
    }
}
