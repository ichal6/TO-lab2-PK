package Cars;

public class Car implements CarSubscriber{
    private boolean isFree;

    public Car() {
        this.isFree = true;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public void update(boolean isFree) {
        this.isFree = isFree;
    }
}
