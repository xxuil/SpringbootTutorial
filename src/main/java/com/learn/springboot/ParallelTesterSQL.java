package com.learn.springboot;

import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParallelTesterSQL implements Runnable {
    private PostMapper pm;

    @Override
    public void run() {
        List<Post> list = pm.findFirst();
    }

    public static void testStarter(int numThreads, PostMapper pm){
        Thread[] threads = new Thread[numThreads];

        for(int i = 0; i < numThreads; i++){
            ParallelTesterSQL p = new ParallelTesterSQL();
            p.pm = pm;
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
