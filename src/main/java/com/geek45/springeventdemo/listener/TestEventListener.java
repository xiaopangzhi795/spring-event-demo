/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.springeventdemo.listener;

import com.geek45.springeventdemo.event.TestEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TestEventListener
 * @Decription:
 * @Author: rubik
 *  rubik create TestEventListener.java of 2022/1/23 4:19 下午
 */
@Component
public class TestEventListener {

    @EventListener(TestEvent.class)
    public void listenerTestEvent(TestEvent testEvent) {
        System.err.println(testEvent.getEventData().getText());
    }

    @Async
    @EventListener(TestEvent.class)
    public void listenerTestEvent2(TestEvent testEvent) {
        System.out.println(testEvent.getEventData().getText());
        if (testEvent.getEventData().getText().equals("hello222")) {
            throw new RuntimeException("12321321");
        }
    }

}
