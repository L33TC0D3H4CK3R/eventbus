package cn.hackforums.event.events;

import cn.hackforums.event.Event;

public final class MessageEvent implements Event {

    private final String message;

    public MessageEvent(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
