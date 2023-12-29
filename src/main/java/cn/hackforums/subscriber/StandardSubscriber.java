package cn.hackforums.subscriber;

import cn.hackforums.event.Event;
import cn.hackforums.listener.EventListener;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * The standard subscriber interface provides implementable methods for subscribing and unsubscribing to the eventbus.
 *
 * @author Creida
 * @since 1.0.0, 12/28/2023
 * @version 1.0.0
 */
public interface StandardSubscriber {

    /**
     * Registers a subscriber to the eventbus.
     * @param subscriber the subscriber to register
     * @param <T> the type of the subscriber
     */
    <T> void subscribe(T subscriber);

    /**
     * Unregisters a subscriber from the eventbus.
     * @param subscriber the subscriber to unregister
     * @param <T> the type of the subscriber
     */
    <T> void unsubscribe(T subscriber);

    /**
     * Gets the map of event types to event listeners.
     * @return the map of event types to event listeners
     */
    Map<Type, EventListener<Event>> getTypeEventListenerMap();
}