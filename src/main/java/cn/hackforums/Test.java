package cn.hackforums;

import cn.hackforums.annotation.BusCache;
import cn.hackforums.event.events.MessageEvent;
import cn.hackforums.listener.EventListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Test {
    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());


    @BusCache()
    private final EventListener<MessageEvent> messageEventEventListener = this::onMessageEvent;


    private void onMessageEvent(final MessageEvent messageEvent) {
        LOGGER.log(Level.INFO, "Message: " + messageEvent.getMessage());
    }
}