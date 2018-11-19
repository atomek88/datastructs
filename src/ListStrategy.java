import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * implement sumof3 strategy naively using arraylists and multiple accesses,helper functions to retrieve sums_list
 * Created by tomaszmichalik on 10/30/18.
 */
public class ListStrategy extends Strategy {
// naively use arraylist
    List<Integer> sums_list; ; // used for naive ? set size?
  // switch to treeset for faster
    //Set<Integer> sums_list;

    ListStrategy(DataStructure ds, DataStructure ds2){
        super(ds );
        switch(ds2) {
            case ARRAYLIST:
                this.sums_list = new ArrayList<>(); // declare new?
                break;
            case LINKEDLIST:
                this.sums_list = new LinkedList<>(); // declare new?
                break;
            case VECTOR:
                this.sums_list = new Vector<>();
                break;
            default:
                break;
        }
    }
    public void append(int[] list){
        for (int i: list){
            super_array.add(i);
        }
        int size = super_array.size() - this.prev_size;
        if (size>=3){
            findSums();
            }
        this.prev_size = size;

    }
    public boolean contains(Integer n){
        //System.out.println("ListStrategy contains called");
        // naive contain
        if (sums_list.contains(n)){return true;}
        return false;
    }

    // helper for find all sums_list
    public void findSums(){
        int idx = (prev_size -2) >0 ? prev_size-2 : 0;
        for (int i=idx; i< super_array.size()-2; i++){
            int sum = super_array.get(i) + super_array.get(i+1) + super_array.get(i+2);
            sums_list.add(sum);
        }

    }
    public String getDataStructureName(){
        //Pattern p = Pattern.compile(".+?\\..+?\\.(\\w)");
        //Matcher m = p.matcher(String.valueOf(sums_list.getClass()));
        String regex = "util.";
        String[] strarr = String.valueOf(this.sums_list.getClass()).split(regex);

        return super.getDataStructureName() +" "+strarr[1];
    }
}
