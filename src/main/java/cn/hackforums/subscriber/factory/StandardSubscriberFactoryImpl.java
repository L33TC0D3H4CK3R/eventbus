package cn.hackforums.subscriber.factory;

import cn.hackforums.subscriber.StandardSubscriber;
import cn.hackforums.subscriber.StandardSubscriberImpl;

public final class StandardSubscriberFactoryImpl implements StandardSubscriberFactory {

    @Override
    public StandardSubscriber createStandardSubscriber() {
        return new StandardSubscriberImpl();
    }
}
