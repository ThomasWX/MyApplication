package com.dn.performance.bitmap_opt.huffman_compression;

import android.graphics.Bitmap;

public class HuffmanCompressModel {
    private static int default_quality = 95;

    /**
     * 计算缩放比例
     */
    public static int getScaledRatio(int bitmapWidth, int bitmapHeight) {
        // 图片的最大分辨率
        int imageWidth = 1080;
        int imageHeight = 1920;

        int scaledRatio = 0;
        if (bitmapWidth > bitmapHeight && bitmapWidth > imageWidth) {
            // 如果图片宽度比高度大，则以宽度为基准
            // TODO 核对视频，bitmapWidth/imageWidth ？
            scaledRatio = bitmapWidth / imageHeight;
        } else if (bitmapWidth < bitmapHeight && bitmapHeight > imageHeight) {
            // 如果图片高度比宽度大，以高度为基准
            scaledRatio = bitmapHeight / imageHeight;
        }
        // 最小比例为1
        if (scaledRatio <= 0) {
            scaledRatio = 1;
        }
        return scaledRatio;

        /**
         * 质量压缩
         * 设置Bitmap options 属性，降低图片的质量，像素不会减少
         */
    }


}
