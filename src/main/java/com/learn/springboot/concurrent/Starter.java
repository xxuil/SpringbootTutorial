package com.learn.springboot.concurrent;

import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.pojo.Post;
import com.learn.springboot.utils.Redis.RedisUtil;

public class Starter {
    public static void SQLStarter(int numThreads, PostMapper pm){
        Thread[] threads = new Thread[numThreads];

        for(int i = 0; i < numThreads; i++){
            ParallelSQL p = new ParallelSQL();
            p.pm = pm;
            Thread t = new Thread(p);
            threads[i] = t;
        }

        threadStarter(numThreads, threads);
    }

    public static void RedisStarter(int numThreads, RedisUtil<Post> util){
        Thread[] threads = new Thread[numThreads];

        for(int i = 0; i < numThreads; i++){
            ParallelRedis p = new ParallelRedis();
            p.util = util;
            Thread t = new Thread(p);
            threads[i] = t;
        }

        threadStarter(numThreads, threads);
    }

    private static void threadStarter(int numThreads, Thread[] threads){
        long startTime = System.nanoTime();
        try{
            for(Thread t : threads){
                t.start();
                t.join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        long expected = System.nanoTime() - startTime;

        System.out.println("Num of Threads: " + numThreads + " time: " + expected);
    }
}
