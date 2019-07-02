package com.learn.springboot;


import com.learn.springboot.mapper.PostMapper;
import com.learn.springboot.mapper.ReplyMapper;
import com.learn.springboot.mapper.UserMapper;
import com.learn.springboot.pojo.Post;
import com.learn.springboot.pojo.Reply;
import com.learn.springboot.pojo.User;
import com.learn.springboot.utils.DateTime.DateTimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    PostMapper pm;

    @Autowired
    UserMapper um;

    @Autowired
    ReplyMapper rm;

    @Test
    public void createUser() {
        for(int i = 0; i < 100; i++){
            User u = new User();
            u.setUid(0);
            u.setUsername("#" + i);
            u.setPassword("*" + i);
            um.add(u);
        }
    }

    @Test
    public void createPost() {
        for(int i = 0; i < 100; i++){
            User u = um.get(i + 1);
            Post p = new Post();
            p.setPid(0);
            p.setTitle("#" + i);
            p.setContent("*" + i + i);
            p.setTime(String.valueOf(System.currentTimeMillis()));
            p.setUser(u);
            p.setUserId(u.getUid());
            p.setViewCount(0);
            p.setReplyCount(0);
            pm.add(p);
        }
    }

    @Test
    public void viewPost() {
        for(int i = 0; i < 100; i++){
            pm.view(i + 1);
        }
    }

    @Test
    public void createReply() {
        for(int i = 0; i < 100; i++) {
            User u = um.get(i + 1);
            Post p = pm.get(i + 1);
            Reply r = new Reply();
            r.setRid(0);
            r.setContent("***" + i + i);
            r.setUserId(u.getUid());
            r.setPostId(p.getPid());
            r.setTime(String.valueOf(DateTimeUtil.currentTimeMillis()));
            pm.reply(i + 1);
            rm.add(r);
        }
    }

//    @Test
//    public void contextLoads() {
//    }

//    @Test
//    public void testAdd(){
//        for(int i = 0; i < 1000; i++){
//            Post p = new Post();
//            p.setPid(0);
//            p.setTitle("#" + i);
//            p.setContent("*" + i + i + i);
//            p.setTime(String.valueOf(System.currentTimeMillis()));
//            pm.add(p);
//        }
//    }


//    @Test
//    public void testDelete() {
//        for(int i = 0; i < 1000; i++){
//            pm.delete(i + 1);
//        }
//    }


//    @Test
//    public void testUpdate(){
//        HashSet<Integer> set = new HashSet<>();
//        randomSet(1, 10000, 1000, set);
//        for(Integer i : set){
//            Post p = new Post();
//            p.setPid(i);
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
//            Assert.assertEquals(p.getPid(), testList.get(i).getPid());
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
//        List<Post> list = pm.findRecent();
//        Assert.assertEquals(list.size(), 10);
//        System.out.println(list);
//    }

//    @Test
//    public void testSQL(){
//        ParallelSQL.testStarter(100000, pm);
//    }
//
//    @Test
//    public void testRedis(){
//        Starter.RedisStarter(1, util);
//    }
//
//    @Test
//    public void testCouchbase(){
//        Starter.CouchbaseStarter(1, ps);
//    }
}
