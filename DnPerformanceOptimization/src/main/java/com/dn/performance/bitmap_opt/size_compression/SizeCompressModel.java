package com.dn.performance.bitmap_opt.size_compression;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.dn.performance.bitmap_opt.FileUtils;

import java.io.File;

/**
 * 尺寸压缩
 */
public class SizeCompressModel {

    /**
     * 通过缩放图片像素来减少图片占用的内存大小
     */
    public static void compress(Bitmap bitmap, File file) {
        // 倍数越大，图片尺寸越小
        int scaledRatio = 8;
        // 计算目标图片尺寸
        int width = bitmap.getWidth() / scaledRatio;
        int height = bitmap.getHeight() / scaledRatio;

        // 创建一个空白的 Bitmap
        Bitmap targetBitmap = Bitmap.createBitmap(width,
                height, Bitmap.Config.ARGB_8888);

        // 将 源 Bitmap 通过 canvas 绘制 到空白的 bitmap 上。
        Canvas canvas = new Canvas(targetBitmap);
        Rect rect = new Rect(0, 0, width, height);
        canvas.drawBitmap(bitmap, null, rect, null);

        FileUtils.saveBitmapToFile(targetBitmap, file);
    }
}
