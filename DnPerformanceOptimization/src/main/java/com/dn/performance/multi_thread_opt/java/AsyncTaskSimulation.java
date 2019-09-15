package com.dn.performance.multi_thread_opt.java;

import android.util.Log;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟异步任务
 */
public class AsyncTaskSimulation {
    private static final String TAG = AsyncTaskSimulation.class.getSimpleName();

    public static void main() {
        int CPU_COUNT = Runtime.getRuntime().availableProcessors(); // 可用的CPU个数
        int CORE_POOL_SIZE = CPU_COUNT + 1; // 核心线程数量
        int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1; // 最大线程数量
        int KEEP_ALIVE = 1; // 线程闲置时间 1 秒

        // 任务队列
        final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingDeque<>(128);

        // 线程 生产工厂
        ThreadFactory sThreadFactory = new ThreadFactory() {
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable runnable) {
                String name = "AsyncTask # " + mCount.getAndIncrement();
                Log.d(TAG, "newThread name: " + name);
                return new Thread(runnable, name);
            }
        };

        // 线程池
        Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor
                (CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);

        // 执行异步任务
        for (int i = 0; i < 200; i++) {
            // 相当于new AsyncTask().execute();
            THREAD_POOL_EXECUTOR.execute(new MyTask());
        }

        //阻塞的时候 会出现 RejectedExecutionException，该异常是怎么抛出来的？
        // ThreadPoolExecutor 源码中，构造函数最后一个参数defaultHandler，这个defaultHandler是new AbortPolicy
        // AbortPolicy 里面会执行RejectedException，也就是说，当它发现任务队列不够用的时候，就会调用该方法抛出异常。

    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Log.d(TAG, Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
