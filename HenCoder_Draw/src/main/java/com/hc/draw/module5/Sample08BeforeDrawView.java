package com.hc.draw.module5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class Sample08BeforeDrawView extends AppCompatEditText {

    public Sample08BeforeDrawView(Context context) {
        super(context);
    }

    public Sample08BeforeDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample08BeforeDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#66BB6A")); // 涂上绿色

        super.draw(canvas);
    }
}
