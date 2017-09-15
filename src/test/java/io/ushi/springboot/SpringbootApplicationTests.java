package io.ushi.springboot;

import io.ushi.springboot.config.quartz.job.DocumentCollectJob;
import io.ushi.springboot.model.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() throws Exception {

        JobDetail jobDetail = JobBuilder.newJob(DocumentCollectJob.class)
                .storeDurably(true)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startNow()
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        Thread.sleep(5000);
    }

    @Test
    public void redisTest() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void redisObjectTest() throws Exception {

        Document document = new Document();
        document.setGroupId("com.qjdchina");
        document.setArtifactId("common-utils");
        document.setVersion("0.0.1");

        ValueOperations<String, Document> operations = redisTemplate.opsForValue();
        operations.set("com.qjdchina", document);
        operations.set("com.qjdchina.temp", document, 1, TimeUnit.SECONDS);

        Thread.sleep(1000);

        Assert.assertEquals(true, redisTemplate.hasKey("com.qjdchina"));
        Assert.assertEquals(false, redisTemplate.hasKey("com.qjdchina.temp"));
    }

}
