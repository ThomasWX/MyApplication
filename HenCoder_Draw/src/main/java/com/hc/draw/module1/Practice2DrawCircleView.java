package com.hc.draw.module1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class Practice2DrawCircleView extends View {

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        //解：
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200, 200, 150, paint);

        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500, 200, 150, paint);

        paint.reset();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(getContext().getColor(android.R.color.holo_blue_bright));
        canvas.drawCircle(200, 500, 150, paint);

        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(60);
        canvas.drawCircle(530, 530, 150, paint);
    }
}
