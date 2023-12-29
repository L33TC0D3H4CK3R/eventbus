package cn.hackforums.bus;

import cn.hackforums.dispatcher.StandardEventDispatcher;
import cn.hackforums.dispatcher.StandardEventDispatcherImpl;
import cn.hackforums.event.Event;
import cn.hackforums.subscriber.StandardSubscriber;
import com.google.inject.Inject;

public final class StandardEventBusImpl implements StandardEventBus {

    private final StandardSubscriber standardSubscriber;

    private final StandardEventDispatcher standardEventDispatcher;

    @Inject
    public StandardEventBusImpl(final StandardSubscriber standardSubscriber,
                                final StandardEventDispatcher standardEventDispatcher) {
        this.standardSubscriber = standardSubscriber;
        this.standardEventDispatcher = standardEventDispatcher;
    }


    @Override
    public <T extends Event> void dispatch(final T event) {
        this.standardEventDispatcher.dispatchEvent(event);
    }

    @Override
    public <T> void subscribe(final T subscriber) {
        this.standardSubscriber.subscribe(subscriber);
    }

    @Override
    public <T> void unsubscribe(final T subscriber) {
        this.standardSubscriber.unsubscribe(subscriber);
    }
}