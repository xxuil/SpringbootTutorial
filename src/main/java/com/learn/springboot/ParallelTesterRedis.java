package com.learn.springboot;

import com.learn.springboot.pojo.Post;
import com.learn.springboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParallelTesterRedis implements Runnable {
    private RedisUtil<Post> util;

    @Override
    public void run() {
        List<Post> list = util.getPageList("newest", 0, 9);
    }

    public static void testStarter(int numThreads, RedisUtil<Post> util){
        Thread[] threads = new Thread[numThreads];

        for(int i = 0; i < numThreads; i++){
            ParallelTesterRedis p = new ParallelTesterRedis();
            p.util = util;
            Thread t = new Thread(p);
            threads[i] = t;
        }

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
