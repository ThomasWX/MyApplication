package com.hc.draw.module4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.hc.draw.R;
import android.util.AttributeSet;
import android.view.View;

public class Sample01ClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Sample01ClipRectView(Context context) {
        super(context);
    }

    public Sample01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;

        canvas.save();
        canvas.clipRect(left + 50, top + 50, left + 300, top + 200);
        canvas.drawBitmap(bitmap, left, top, paint);
        canvas.restore();
    }
}
