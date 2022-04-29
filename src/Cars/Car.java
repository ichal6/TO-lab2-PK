package Cars;

public class Car {
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

}
