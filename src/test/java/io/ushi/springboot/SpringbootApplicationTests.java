package io.ushi.springboot;

import io.ushi.springboot.config.quartz.job.DocumentCollectJob;
import io.ushi.springboot.model.Document;
import io.ushi.springboot.service.DocumentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
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

    @SpyBean
    private DocumentService documentService;

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
    public void mockTest() throws Exception {

        Mockito.when(documentService.sayHello()).thenReturn("mock");
        Assert.assertEquals("mock", documentService.sayHello());
        Assert.assertEquals("hi", documentService.sayHi());
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

    @Test
    public void jdbcTest() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://10.1.1.64:3306/receiver";
        String username = "admin";
        String password = "westos";
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet resultSet = metadata.getTables(null, "receiver", "clms_credit", new String[]{"TABLE"});
            Assert.assertTrue(resultSet.next());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
