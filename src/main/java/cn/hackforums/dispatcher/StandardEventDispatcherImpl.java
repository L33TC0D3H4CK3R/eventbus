package cn.hackforums.dispatcher;

import cn.hackforums.event.Event;
import cn.hackforums.listener.EventListener;
import cn.hackforums.subscriber.StandardSubscriber;
import com.google.inject.Inject;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The standard event dispatcher implementation is a class that implements the {@link StandardEventDispatcher} interface.
 *
 * <p>
 *     The standard event dispatcher class is used to asynchronously dispatch events to their respective event listeners.
 * </p>
 *
 * @author Creida
 * @since 1.0.0, 12/28/2023
 * @version 1.0.0
 */
public final class StandardEventDispatcherImpl implements StandardEventDispatcher {

    /**
     * The type event listener map is a map of types to event listeners.
     *
     * <p>
     *     This map is used to store the event listeners for each type of event.
     *     This allows us to dispatch events to the correct event listener.
     *     This map is populated by the {@link StandardSubscriber} class.
     * </p>
     */
    private final Map<Type, EventListener<Event>> typeEventListenerMap;

    /**
     * The logger is a robust form of debugging, and sending messages to the console. It is extremely useful for debugging, and is used in many applications.
     */
    private static final Logger LOGGER = Logger.getLogger(StandardEventDispatcherImpl.class.getName());

    /**
     * The executor constant creates a new thread pool with a fixed number of threads equal to the number of processors available to the JVM.
     *
     * <p>
     *     The executor service allows us to asynchronously dispatch events with thread safety.
     * </p>
     *
     */
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Inject
    public StandardEventDispatcherImpl(final StandardSubscriber standardSubscriber) {
        this.typeEventListenerMap = standardSubscriber.getTypeEventListenerMap();
    }

    @Override
    public <T extends Event> void dispatchEvent(final T event) {
        final EventListener<T> listener = (EventListener<T>) this.typeEventListenerMap.get(event.getClass());

        if (listener == null) {
            LOGGER.log(Level.SEVERE, "Listener not found for event: " + event.getClass().getSimpleName());
            return;
        }

        // asynchronously dispatch with the executor service
        EXECUTOR_SERVICE.execute(() -> listener.invoke(event));
    }

}