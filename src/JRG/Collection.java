package JRG;

import Coordinates.Coordinates;
import Iterator.Iterator;

public interface Collection {
    public Iterator createIterator(Coordinates coordinates);
    public void notifyAllUnits();
}
