package com.dn.performance.bitmap_opt.huffman_compression;

import android.graphics.Bitmap;

import java.io.*;

public class HuffmanCompressModel {

    private static int DEFAULT_QUAILTY = 95;


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

    }

    /**
     * 调用native方法
     */
    public static void saveBitmap(Bitmap bitmap, int quality, String fileName, boolean optimize) {
        compressBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), quality, fileName.getBytes(), optimize);
    }

    /**
     * 调用底层 bitherlibjni.c 中的方法
     */
    public static native String compressBitmap(Bitmap bitmap, int width, int height, int quality, byte[] fileNameBytes, boolean optimize);



}
