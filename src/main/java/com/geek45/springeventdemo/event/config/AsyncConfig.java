/**
 * From geek45.com
 * Email to : rubixgeek795@gmail.com
 */
package com.geek45.springeventdemo.event.config;

import com.geek45.threaddemo.thread.ThreadMonitor;
import com.geek45.threaddemo.thread.config.ThreadPoolConfiguration;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * @ClassName: AsyncConfig
 * @Decription:
 * @Author: rubik
 *  rubik create AsyncConfig.java of 2022/1/23 4:31 下午
 */
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    private ThreadPoolConfiguration threadPoolConfiguration;

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    @Override
    public Executor getAsyncExecutor() {
        return ThreadMonitor.initPool(threadPoolConfiguration);
    }

    @Autowired
    public void init(ThreadPoolConfiguration configuration) {
        this.threadPoolConfiguration = threadPoolConfiguration;
    }

}
