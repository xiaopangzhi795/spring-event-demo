/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.springeventdemo.event.service.impl;

import com.geek45.springeventdemo.event.TestEvent;
import com.geek45.springeventdemo.event.model.TestEventData;
import com.geek45.springeventdemo.event.service.TestEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TestEventServiceImpl
 * @Decription:
 * @Author: rubik
 *  rubik create TestEventServiceImpl.java of 2022/1/23 4:20 下午
 */
@Service
public class TestEventServiceImpl implements TestEventService {

    public ApplicationEventPublisher publisher;

    @Override
    public void publisher(String text) {
        TestEventData data = new TestEventData();
        data.setText(text);
        publisher.publishEvent(new TestEvent(this, data));
    }

    @Autowired
    public void init(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
