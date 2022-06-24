package com.company;

import java.time.Duration;
import java.time.LocalTime;
import java.lang.Exception;
public class FindMain {
    private int min = Integer.MAX_VALUE;

    public void FindMain(int[] arr, int threadsNum) throws Exception
    {
        LocalTime startTime = LocalTime.now();

        Thread[] threads = new Thread[threadsNum];

        min = Integer.MAX_VALUE;

        Object lock = new Object();

        for (int threadIdx = 0; threadIdx < threads.length; threadIdx++)
        {
            int threadIdxLocal = threadIdx;
            threads[threadIdx] = new Thread(() ->
            {
                for (int i = arr.length * threadIdxLocal / threadsNum; i < arr.length * (threadIdxLocal + 1) / threadsNum; i++)
                {
                    if (arr[i] < min)
                    {
                        synchronized (lock)
                        {
                            if (arr[i] < min)
                            {
                                min = arr[i];
                            }
                        }
                    }
                }
            });

            threads[threadIdx].run();
        }
        for (Thread item : threads)
        {
            item.join();
        }

        LocalTime endTime = LocalTime.now();

        System.out.println(threadsNum + " поток: минимальный " + min + ": "+ Duration.between(startTime, endTime).toMillis() + "ms");
    }
}
