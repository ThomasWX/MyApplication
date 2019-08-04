package com.hc.plus.c6_drawing;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hc.plus.R;
import com.hc.utils.Utils;

public class AvatarView extends View {
    private static final float WIDTH = Utils.dp2px(300);
    private static final float PADDING = Utils.dp2px(50);
    private static final float EDGE_WIDTH = Utils.dp2px(10);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    Bitmap bitmap;
    RectF savedArea = new RectF();

    public AvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = getAvatar((int) WIDTH);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 此方法的调用时机是：
        // 设置矩形区域的左上、右下两个顶点坐标
        savedArea.set(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH);
    }

    private Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.avatar_rengwuxian, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth; // TODO
        options.inTargetDensity = width; // TODO
        return BitmapFactory.decodeResource(getResources(), R.drawable.avatar_rengwuxian, options);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(PADDING, PADDING, PADDING + WIDTH, PADDING + WIDTH, paint);
        int saved = canvas.saveLayer(savedArea,paint);
        canvas.drawOval(PADDING + EDGE_WIDTH, PADDING + EDGE_WIDTH, PADDING + WIDTH - EDGE_WIDTH, PADDING + WIDTH - EDGE_WIDTH, paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(bitmap,PADDING,PADDING,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saved);
    }
}
