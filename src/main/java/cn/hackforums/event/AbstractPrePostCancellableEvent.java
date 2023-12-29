package cn.hackforums.event;

public abstract class AbstractPrePostCancellableEvent implements PrePostCancellableEvent {

    private boolean cancelled;
    private boolean post = false;

    protected AbstractPrePostCancellableEvent() {}

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isPost() {
        return this.post;
    }

    @Override
    public void setPost(final boolean post) {
        this.post = post;
    }
}
