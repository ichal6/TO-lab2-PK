package Iterator;

import Coordinates.Coordinates;
import JRG.*;

import java.util.*;

public class JRGIterator implements Iterator{
    private Coordinates coordinates;
    private Map<Double, List<JRG>> JRGLocations;
    private double[] arrayOfKeys;
    private int position;
    private int countOfElements;

    public JRGIterator(Coordinates coordinates, JRG[] JRGLists) {
        this.coordinates = coordinates;
        this.JRGLocations = new HashMap<Double, List<JRG>>();
        this.position = 0;
        this.arrayOfKeys = new double[JRGLists.length];
        this.countOfElements = JRGLists.length;

        prepareMap(JRGLists);
    }

    private void prepareMap(JRG[] array){
        int index = 0;
        for(JRG jrg: array){
            if (jrg == null){
                throw new NoSuchElementException("You have to add more than one JRG unit!");
            }
            var result = jrg.compareCoordinates(this.coordinates);
            if( !JRGLocations.containsKey(result)){
                this.JRGLocations.put(result, new LinkedList<JRG>());
            }
            this.JRGLocations.get(result).add(jrg);
            if(JRGLocations.containsKey(result)) {
                arrayOfKeys[index++] = result;
            }
        }

        Arrays.sort(arrayOfKeys);
    }

    @Override
    public JRG getNext() {
        List<JRG> units = this.JRGLocations.get(arrayOfKeys[this.position]);

        if(units.size() == 1){
            this.position++;
            return units.get(0);
        } else{
            JRG jrg = units.get(0);
            units.remove(0);
            return jrg;
        }
    }

    @Override
    public boolean hasMore() {
        if (this.position >= arrayOfKeys.length)
            return false;
        else
            return true;
    }
}
