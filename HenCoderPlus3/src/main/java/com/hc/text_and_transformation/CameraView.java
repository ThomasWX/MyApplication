package com.hc.text_and_transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.hc.plus3.Utils;

public class CameraView extends View {
    private static final int image_width = (int) Utils.dp2px(200);
    private static final int image_padding = (int) Utils.dp2px(100);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap image;
    Camera camera = new Camera();

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    {
        image = Utils.getAvatar(getResources(), image_width);
        camera.rotateX(45);
        camera.setLocation(0, 0, Utils.getZforCamera());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(image_padding + image_width / 2, image_padding + image_width / 2);// 平移dx,dy距离
        canvas.rotate(-30); // 逆时针旋转30度
        canvas.clipRect(-image_width, -image_width, image_width, 0);// 范围裁切
    }
}
