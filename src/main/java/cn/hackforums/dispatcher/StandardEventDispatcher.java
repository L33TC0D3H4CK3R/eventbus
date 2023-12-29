package cn.hackforums.dispatcher;

import cn.hackforums.event.Event;

@FunctionalInterface
public interface StandardEventDispatcher {
    <T extends Event> void dispatchEvent(final T event);
}