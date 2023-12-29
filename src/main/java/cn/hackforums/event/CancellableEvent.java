package cn.hackforums.event;

public interface CancellableEvent extends Event {
    boolean isCancelled();

    void setCancelled(boolean cancelled);
}
