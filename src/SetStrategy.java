import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Strategy that uses sets
 * Created by tomaszmichalik on 10/31/18.
 */
public class SetStrategy extends Strategy{
    Set<Integer> set;
    // try treemap as well
    SetStrategy(DataStructure ds, DataStructure ds2){
        super(ds);
        switch(ds2) {
            case HASHSET: this.set = new HashSet<>();
                break;
            case TREESET: this.set = new TreeSet<>();
                break;
            default:
                break;
        }
        // test what data structure was created
        System.out.println(this.set.getClass());
    }
    public void append(int[] list){
        for (int i: list){
            super_array.add(i);
        }
        //System.out.println(this.super_array); // check array appending
        findSums();


        prev_size = super_array.size();

    }
    public boolean contains(Integer n){
        //System.out.println("MapStrategy contains called");
        // can modify with treeset to cut in half.. get rangeSet
        if (set.contains(n)){return true;
        }
        return false;
    }
    public void findSums(){
            int idx = (prev_size - 2) > 0 ? prev_size - 2 : 0;
            for (int i = idx; i < super_array.size() - 2; i++) {
                int sum = super_array.get(i) + super_array.get(i + 1) + super_array.get(i + 2);
                set.add(sum);
            }
        }
    public String getDataStructureName(){
       // Pattern p = Pattern.compile(".+?\\..+?\\.(\\w)");
       // Matcher m = p.matcher(String.valueOf(set.getClass()));
        String regex = "util.";
        String[] strarr = String.valueOf(this.set.getClass()).split(regex);
        return super.getDataStructureName() +" "+strarr[1];
    }
}

