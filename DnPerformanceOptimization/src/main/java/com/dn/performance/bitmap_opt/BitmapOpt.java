package com.dn.performance.bitmap_opt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BitmapOpt {

    public void test() {
        Bitmap bitmap;
        // BitmapFactory.decodeResource()
    }

    /**
     * 图片质量压缩
     */
    public void imageQualityCompression(View view) {
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        String path = "";
//        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
//        int quality = 50; // 50% 范围是 0~100
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, bos);
//
//        FileOutputStream fos = new FileOutputStream(file);
//        fos.write(bos.toByteArray());
//        fos.flush();
//        fos.close();
    }

    /**
     * 图片尺寸压缩
     */
    public void imageSizeCompression(Bitmap bitmap, File file) {
        int factor = 4; // 压缩尺寸倍数，值越大，图片尺寸越小。
        /**
         * 解说最后一个参数：
         * 颜色通道：
         */
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth() / factor, bitmap.getHeight() / factor, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(result);
        RectF rect = new RectF(0, 0, bitmap.getWidth() / factor, bitmap.getHeight() / factor);
        canvas.drawBitmap(bitmap, null, rect, null);

        // 输出到文件

    }
}
