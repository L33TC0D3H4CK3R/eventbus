package cn.hackforums.event;

public interface PrePostEvent extends Event {
    boolean isPre();

    boolean isPost();

    void setPost(boolean state);
}
