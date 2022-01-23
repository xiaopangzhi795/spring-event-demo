/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.springeventdemo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName: BaseEvent
 * @Decription:
 * @Author: rubik
 *  rubik create BaseEvent.java of 2022/1/23 4:15 下午
 */
public abstract class BaseEvent<T> extends ApplicationEvent {

    private T eventData;

    public BaseEvent(Object source, T eventData) {
        super(source);
        this.eventData = eventData;
    }

    public T getEventData() {
        return eventData;
    }

    public void setEventData(T eventData) {
        this.eventData = eventData;
    }
}
