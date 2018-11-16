package com.hencoder.plus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.view.View;

import com.hencoder.plus.R;
import com.hencoder.plus.Utils;

public class ImageTextView extends View {
    private static final float IMAGE_WIDTH = Utils.dp2px(100);
    private static final float IMAGE_OFFSET = Utils.dp2px(80);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean justo sem, sollicitudin in maximus a, vulputate id magna. Nulla non quam a massa sollicitudin commodo fermentum et est. Suspendisse potenti. Praesent dolor dui, dignissim quis tellus tincidunt, porttitor vulputate nisl. Aenean tempus lobortis finibus. Quisque nec nisl laoreet, placerat metus sit amet, consectetur est. Donec nec quam tortor. Aenean aliquet dui in enim venenatis, sed luctus ipsum maximus. Nam feugiat nisi rhoncus lacus facilisis pellentesque nec vitae lorem. Donec et risus eu ligula dapibus lobortis vel vulputate turpis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In porttitor, risus aliquam rutrum finibus, ex mi ultricies arcu, quis ornare lectus tortor nec metus. Donec ultricies metus at magna cursus congue. Nam eu sem eget enim pretium venenatis. Duis nibh ligula, lacinia ac nisi vestibulum, vulputate lacinia tortor.";
    float[] cutWidth = new float[1];

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        bitmap = getAvatar((int) Utils.dp2px(100));
        paint.setTextSize(Utils.dp2px(14));
        paint.getFontMetrics(fontMetrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, getWidth() - IMAGE_WIDTH, IMAGE_OFFSET, paint);
        int length = text.length();
        float verticalOffset = - fontMetrics.top;
        for (int start = 0; start < length; ) {
            int maxWidth;
            float textTop = verticalOffset + fontMetrics.top;
            float textBottom = verticalOffset + fontMetrics.bottom;
            if (textTop > IMAGE_OFFSET && textTop < IMAGE_OFFSET + IMAGE_WIDTH
                    || textBottom > IMAGE_OFFSET && textBottom < IMAGE_OFFSET + IMAGE_WIDTH) {
                // 文字和图片在同一行
                maxWidth = (int) (getWidth() - IMAGE_WIDTH);
            } else {
                // 文字和图片不在同一行
                maxWidth = getWidth();
            }
            int count = paint.breakText(text, start, length, true, maxWidth, cutWidth);
            canvas.drawText(text, start, start + count, 0, verticalOffset, paint);
            start += count;
            verticalOffset += paint.getFontSpacing();
        }
    }

    Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.avatar_rengwuxian, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.avatar_rengwuxian, options);
    }
}
