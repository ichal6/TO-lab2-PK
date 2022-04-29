package Iterator;

import Coordinates.Coordinates;
import JRG.JRG;

public class JRGIterator implements Iterator{
    private Coordinates coordinates;

    public JRGIterator(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public JRG getNext() {
        return null;
    }

    @Override
    public boolean hasMore() {
        return false;
    }
}
