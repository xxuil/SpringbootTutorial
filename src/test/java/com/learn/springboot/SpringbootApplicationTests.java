package com.learn.springboot;

import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.pojo.Post;
import com.learn.springboot.utils.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    PostMapper pm;

    @Autowired
    RedisUtil<Post> util;

//    @Test
//    public void contextLoads() {
//    }

//    @Test
//    public void testAdd(){
//        for(int i = 0; i < 10000; i++){
//            Post p = new Post();
//            p.setId(0);
//            p.setTitle("#" + i);
//            p.setContent("*" + i + i + i);
//            p.setTime(String.valueOf(System.currentTimeMillis()));
//            pm.add(p);
//        }
//    }


//    @Test
//    public void testUpdate(){
//        HashSet<Integer> set = new HashSet<>();
//        randomSet(1, 10000, 1000, set);
//        for(Integer i : set){
//            Post p = new Post();
//            p.setId(i);
//            p.setTitle("new");
//            p.setContent("newwww");
//            p.setTime(String.valueOf(System.currentTimeMillis()));
//            pm.update(p);
//        }
//    }

//    @Test
//    public void testRedisA(){
//        List<Post> testList = pm.findAll();
//        util.setCatcheList("newest", testList);
//    }

//    @Test
//    public void testRedisB(){
//        List<Post> testList = util.getCatcheList("newest");
//        List<Post> that = pm.findAll();
//        int i = 0;
//        for(Post p : that){
//            Assert.assertEquals(p.getId(), testList.get(i).getId());
//            i += 1;
//        }
//    }

//    @Test
//    public void testRedisC(){
//        List<Post> list = util.getPageList("newest", 0, 9);
//        Assert.assertEquals(list.size(), 10);
//        System.out.println(list);
//    }


//    @Test
//    public void testFindPage(){
//        List<Post> list = pm.findFirst();
//        Assert.assertEquals(list.size(), 10);
//        System.out.println(list);
//    }

    @Test
    public void testSQL(){
        ParallelTesterSQL.testStarter(100000, pm);
    }

    @Test
    public void testRedis(){
        ParallelTesterRedis.testStarter(100000, util);
    }

    public static void randomSet(int min, int max, int n, HashSet<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            randomSet(min, max, n - setSize, set);// 递归
        }
    }

}
