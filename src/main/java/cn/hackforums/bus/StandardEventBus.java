package cn.hackforums.bus;

import cn.hackforums.event.Event;

/**
 * The standard event bus interface is used for dispatching events, subscribing listeners, and unsubscribing listeners.
 *
 * @author Creida
 * @since 1.0.0, 12/28/2023
 * @version 1.0.0
 *
 */
public interface StandardEventBus {

    /**
     * Dispatches an event to all registered subscribers.
     * @param event The event to dispatch.
     * @param <T> The type of the event.
     */
    <T extends Event> void dispatch(T event);

    /**
     * Registers a subscriber to the eventbus.
     * @param subscriber The subscriber to register.
     * @param <T> The type of the subscriber.
     */
    <T> void subscribe(T subscriber);

    /**
     * Unregisters a subscriber from the eventbus.
     * @param subscriber The subscriber to unregister.
     * @param <T> The type of the subscriber.
     */
    <T> void unsubscribe(T subscriber);
}
