package cn.hackforums.guice;

import cn.hackforums.bus.StandardEventBus;
import cn.hackforums.bus.StandardEventBusImpl;
import cn.hackforums.subscriber.StandardSubscriber;
import cn.hackforums.subscriber.StandardSubscriberImpl;
import com.google.inject.AbstractModule;

/**
 * The Event Bus Guice Module is used for binding interfaces to their implementations.
 *
 * @author Creida
 * @since 1.0.0, 12/28/2023
 * @version 1.0.0
 */
public final class EventBusGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        super.bind(StandardEventBus.class).to(StandardEventBusImpl.class);
        super.bind(StandardSubscriber.class).to(StandardSubscriberImpl.class);
    }
}