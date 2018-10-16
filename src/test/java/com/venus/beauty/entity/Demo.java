package com.venus.beauty.entity;

import com.venus.beauty.mapper.ScheduledMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lx
 * @time 2018/9/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Demo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void method1(){
        stringRedisTemplate.opsForValue().set("111","111");
    }

    @Autowired
    private ScheduledMapper scheduledMapper;

    @Test
    public void  method2(){
        List<Scheduled> list = scheduledMapper.getAllSche();
        System.out.println(list.size());
    }
}
