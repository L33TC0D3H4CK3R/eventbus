package cn.hackforums.event;

public abstract class AbstractPrePostState implements PrePostEvent {

    private boolean post = false;


    @Override
    public boolean isPost() {
        return this.post;
    }

    @Override
    public void setPost(boolean post) {
        this.post = post;
    }
}
