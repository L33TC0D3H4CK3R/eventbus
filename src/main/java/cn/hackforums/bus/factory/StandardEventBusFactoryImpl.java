package cn.hackforums.bus.factory;

import cn.hackforums.bus.StandardEventBus;
import cn.hackforums.bus.StandardEventBusImpl;
import cn.hackforums.dispatcher.StandardEventDispatcher;
import cn.hackforums.subscriber.StandardSubscriber;
import cn.hackforums.subscriber.factory.StandardSubscriberFactory;

public final class StandardEventBusFactoryImpl implements StandardEventBusFactory {

    private final StandardSubscriber standardSubscriber;

    private final StandardEventDispatcher standardEventDispatcher;

    public StandardEventBusFactoryImpl(final StandardSubscriberFactory standardSubscriberFactory,
                                       final StandardEventDispatcher standardEventDispatcher) {
        this.standardSubscriber = standardSubscriberFactory.createStandardSubscriber();
        this.standardEventDispatcher = standardEventDispatcher;
    }

    @Override
    public StandardEventBus createStandardEventBus() {
        return new StandardEventBusImpl(
                this.standardSubscriber,
                this.standardEventDispatcher
        );
    }
}
