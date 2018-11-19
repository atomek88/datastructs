import java.time.Duration;
import java.util.*;

/**
 * superclass of various strategies. trying initially to use for sumof3 timings for diff data structures but using strategy pattern
 * + abstract super class to hold my variables, should be easily extensible for other strategies
 * Created by tomaszmichalik on 10/30/18.
 */
public abstract class Strategy implements Sumof3Strategy {

    public enum DataStructure{
        ARRAYLIST, HASHMAP, HASHSET, TREESET, TREEMAP, LINKEDLIST, HASHTABLE, STACK, QUEUE, DEQUE, VECTOR
    }
    public List<Integer> super_array; // can provide different implementations linkedlist, arraylist etc
    protected int prev_size;
    public Duration duration_append;
    public Duration duration_sum;
    public Duration duration_search;
    public Strategy(DataStructure ds ){ //
        switch(ds) {
            case ARRAYLIST: this.super_array = new ArrayList<>(); // declare new?
                break;
            case LINKEDLIST: this.super_array = new LinkedList<>(); // declare new?
                break;
            case STACK: this.super_array = new Stack<>(); // declare new?
                break;
            case VECTOR: this.super_array = new Vector<>(); // declare new?
                break;
            default:
                break;
        }
        this.prev_size =0;
        System.out.println(this.super_array.getClass());
    }

    public abstract void append(int[] list);
    public abstract boolean contains(Integer n);
    public abstract void findSums();
    @Override
    public String toString(){
        String regex = "@";
        String[] str = String.valueOf(this.getClass()).split(regex);
        return str[0];
    }
    public String getDataStructureName(){
        String regex = "util.";
        String[] strarr = String.valueOf(this.super_array.getClass()).split(regex);
        return strarr[1];

    }
}
