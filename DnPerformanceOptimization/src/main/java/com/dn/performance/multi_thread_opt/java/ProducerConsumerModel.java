package com.dn.performance.multi_thread_opt.java;

import android.util.Log;

/**
 * 总结：
 * 1. volatile 关键字的作用：
 * 2. 线程优化的两个方法：
 *  1).
 *  2).
 */
public class ProducerConsumerModel {
    private static final String TAG = ProducerConsumerModel.class.getSimpleName();

    public static void main() {
        Object lock = new Object();
        new Producer(lock).start();
        new Consumer(lock).start();
    }

    // 产品
    static class ProductObject {
        // 线程操作变量可见
        public volatile static String value;
    }

    // 生产者线程
    static class Producer extends Thread {
        Object lock;

        public Producer(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            // 不断生产 产品
            while (true) {
                synchronized (lock) { // 互斥锁
                    // 如果产品未被消费，等待消费者消费完成
                    if (ProductObject.value != null) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 产品已经消费完成，生产新的产品
                    ProductObject.value = "New Product : " + System.currentTimeMillis();
                    Log.d(TAG, "生产产品：" + ProductObject.value);
                    lock.notify(); // 生产完成，通知消费者进行消费
                }
            }
        }
    }

    // 消费者线程
    static class Consumer extends Thread {
        Object lock;

        public Consumer(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // 如果没有产品可消费
                    if (ProductObject.value == null) {
                        // 等待
                        try {
                            lock.wait(); // 这个方法是阻塞的
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, "消费产品：" + ProductObject.value);
                        ProductObject.value = null;
                        lock.notify(); // 消费完成，通知生产者，继续生产
                    }
                }

            }
        }
    }
}
