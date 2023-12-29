package cn.hackforums.subscriber.factory;

import cn.hackforums.subscriber.StandardSubscriber;

/**
 * A factory for creating {@link StandardSubscriber}s.
 *
 * @author Creida
 * @since 1.0.0, 12/28/2023
 * @version 1.0.0
 */
public interface StandardSubscriberFactory {
    StandardSubscriber createStandardSubscriber();
}