package cn.hackforums;

import cn.hackforums.bus.StandardEventBus;
import cn.hackforums.event.events.MessageEvent;
import cn.hackforums.guice.EventBusGuiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class Main {

    public static void main(final String[] args) {
        // use factories when implementing this :angry:
        final Injector injector = Guice.createInjector(new EventBusGuiceModule());
        final StandardEventBus eventBus = injector.getInstance(StandardEventBus.class);

        final Test test = new Test();
        eventBus.subscribe(test);

        eventBus.dispatch(new MessageEvent("Hello Yo"));

        eventBus.unsubscribe(test);
    }

}