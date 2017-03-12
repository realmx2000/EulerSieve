/**
 * Created by realmx2000 on 2/1/17.
 */
import java.util.*;

public class Sieves {
    private ArrayList<Integer> sieve = new ArrayList<Integer>();
    private int size;

    /* Constructor; populates an arraylist with integers up to N */
    public Sieves(int size){
        this.size = size;
        sieve.ensureCapacity( size);
        for(int i = 2; i <= size; i++)
            sieve.add(i);
    }

    public ArrayList<Integer> getCurrentSieve(){
        return sieve;
    }

    /* Runs one iteration of the Euler Sieve. Returns the elements that were removed. */
    public ArrayList<Integer> applyEulerSieve(){
        int firstPrime = sieve.get(0);
        int current = firstPrime;
        int i = 1;
        ArrayList<Integer> removedInts = new ArrayList<Integer>();
        while(current <= size){
            current = firstPrime * i++;
            removedInts.add(current);
            current = firstPrime * i;
        }
        for(Integer removedInt : removedInts)
            if(sieve.contains(removedInt))
                sieve.remove(removedInt);
        return removedInts;
    }
}
