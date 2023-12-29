package cn.hackforums.dispatcher.factory;

import cn.hackforums.dispatcher.StandardEventDispatcher;
import cn.hackforums.dispatcher.StandardEventDispatcherImpl;
import cn.hackforums.subscriber.StandardSubscriber;
import cn.hackforums.subscriber.factory.StandardSubscriberFactory;

public final class StandardEventDispatcherFactoryImpl implements StandardEventDispatcherFactory {

    private final StandardSubscriber standardSubscriber;

    public StandardEventDispatcherFactoryImpl(final StandardSubscriberFactory standardSubscriberFactory) {
        this.standardSubscriber = standardSubscriberFactory.createStandardSubscriber();
    }

    @Override
    public StandardEventDispatcher createStandardEventDispatcher() {
        return new StandardEventDispatcherImpl(
                this.standardSubscriber
        );
    }
}
