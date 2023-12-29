package cn.hackforums.subscriber;

import cn.hackforums.annotation.BusCache;
import cn.hackforums.event.Event;
import cn.hackforums.listener.EventListener;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class StandardSubscriberImpl implements StandardSubscriber {
    private final Map<Type, EventListener<Event>> typeEventListenerMap;

    private static final Logger LOGGER = Logger.getLogger(StandardSubscriberImpl.class.getName());

    public StandardSubscriberImpl() {
        this.typeEventListenerMap = new HashMap<>();
    }

    @Override
    public <T> void subscribe(final T subscriber) {
        for (final Field field : subscriber.getClass().getDeclaredFields()) {

            // if the field isn't annotated with bus cache we continue.
            if (!field.isAnnotationPresent(BusCache.class)) {
                continue;
            }

            // cache the fields accessibility state.
            final boolean accessible = field.isAccessible();

            // set the accessibility of the field to true so we can access it.
            if (!accessible) {
                field.setAccessible(true);
            }

            try {
                final Object fieldValue = field.get(subscriber);

                // if the field isnt a event listener but is annotated with bus cache we return and print out an error.
                if (!(fieldValue instanceof EventListener)) {
                    LOGGER.log(Level.SEVERE, "Field " + field.getName() + " in " + subscriber.getClass().getSimpleName() + " is not an instance of EventListener.");
                    return;
                }

                // get the listener and type from the field.
                final EventListener<Event> listener = (EventListener<Event>) fieldValue;
                final Type type = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];

                // if the type already exists in the map we return so we don't overwrite the listener
                if (this.typeEventListenerMap.containsKey(type)) {
                    LOGGER.log(Level.SEVERE, "Listener for type " + type.getTypeName() + " already exists.");
                    return;
                }

                // put the type and listener in the map if it doesn't already exist
                this.typeEventListenerMap.put(type, listener);
            } catch (final IllegalAccessException e) {
                LOGGER.log(Level.SEVERE, "Failed to access field " + field.getName() + " in " + subscriber.getClass().getSimpleName() + ".", e);
            }

            // Reset the accessibility of the field when done
            field.setAccessible(accessible);
        }
    }

    @Override
    public <T> void unsubscribe(final T subscriber) {
        for (final Field field : subscriber.getClass().getDeclaredFields()) {
            // if the field isn't annotated with bus cache we continue.
            if (!field.isAnnotationPresent(BusCache.class)) {
                continue;
            }

            // cache the fields accessibility state.
            final boolean accessible = field.isAccessible();

            // set the accessibility of the field to true so we can access it.
            if (!accessible) {
                field.setAccessible(true);
            }

            try {
                final Object fieldValue = field.get(subscriber);

                // if the field isnt a event listener but is annotated with bus cache we return and print out an error.
                if (!(fieldValue instanceof EventListener)) {
                    LOGGER.log(Level.SEVERE, "Field " + field.getName() + " in " + subscriber.getClass().getSimpleName() + " is not an instance of EventListener.");
                    return;
                }

                // get the listener and type from the field.
                final EventListener<Event> listener = (EventListener<Event>) fieldValue;
                final Type type = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];

                // if the type already exists in the map we return so we don't overwrite the listener
                if (this.typeEventListenerMap.containsKey(type) && this.typeEventListenerMap.containsValue(listener)) {
                   this.typeEventListenerMap.remove(type, listener);
                   return;
                } else {
                    LOGGER.log(Level.SEVERE, "Listener for type " + type.getTypeName() + " does not exist.");
                    return;
                }

            } catch (final IllegalAccessException e) {
                LOGGER.log(Level.SEVERE, "Failed to access field " + field.getName() + " in " + subscriber.getClass().getSimpleName() + ".", e);
            }

            field.setAccessible(accessible);
        }
    }

    @Override
    public Map<Type, EventListener<Event>> getTypeEventListenerMap() {
        return this.typeEventListenerMap;
    }
}
