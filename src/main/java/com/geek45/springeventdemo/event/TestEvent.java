/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.springeventdemo.event;

import com.geek45.springeventdemo.event.model.TestEventData;

/**
 * @ClassName: TestEvent
 * @Decription:
 * @Author: rubik
 * rubik create TestEvent.java of 2022/1/23 4:17 下午
 */
public class TestEvent extends BaseEvent<TestEventData> {

    public TestEvent(Object source, TestEventData testEventData) {
        super(source, testEventData);
    }
}
