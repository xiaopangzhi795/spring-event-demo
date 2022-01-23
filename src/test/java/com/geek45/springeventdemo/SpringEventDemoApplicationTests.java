package com.geek45.springeventdemo;

import com.geek45.springeventdemo.event.service.TestEventService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
@SpringBootTest(classes = SpringEventDemoApplication.class)
class SpringEventDemoApplicationTests {

    @Autowired
    public void init(TestEventService testEventService) {
        this.testEventService = testEventService;
    }

    private static final Logger logger = LoggerFactory.getLogger(SpringEventDemoApplicationTests.class);
    private TestEventService testEventService;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Test
    void contextLoads() {
        testEventService.publisher("hello");

        testEventService.publisher("hello222");
        try {
            lock.lock();
            condition.await();
        } catch (Exception e) {
            logger.error("exception.. ", e);
        }finally {
            lock.unlock();
        }
    }

}
