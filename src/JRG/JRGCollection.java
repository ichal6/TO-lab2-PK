package JRG;

import Coordinates.Coordinates;
import Iterator.*;

public class JRGCollection implements Collection{
    private int maxUnits = 10;
    private int index = 0;
    private JRG[] JRGArray;

    public JRGCollection(int numberOfUnits) {
        this.maxUnits = numberOfUnits;
        JRGArray = new JRG[maxUnits];
    }

    public void addItem(JRG newJRG)
    {
        if (index >= maxUnits)
            System.err.println("Full");
        else
        {
            JRGArray[this.index] = newJRG;
            index += 1;
        }
    }
    @Override
    public void notifyAllUnits(){
        for(int i = 0; i < JRGArray.length; i++){
            JRGArray[i].reset();
        }
    }

    @Override
    public Iterator createIterator(Coordinates coordinates) {
        return new JRGIterator(coordinates, this.JRGArray);
    }

}
