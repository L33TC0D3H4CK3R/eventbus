package cn.hackforums.listener;

import cn.hackforums.event.Event;

/**
 * The event listener interface is used for invoking events.
 * @param <T> the type of event
 *
 * @author Creida
 * @since 1.0.0, 12/28/2023
 * @version 1.0.0
 */
@FunctionalInterface
public interface EventListener<T extends Event> {
    void invoke(T event);
}