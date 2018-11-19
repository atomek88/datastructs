import javax.xml.crypto.Data;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** more optimal (supposed) strategy for sumof3
 * using arraylist and hashmap, implements append and contains methods more optimally
 * Created by tomaszmichalik on 10/30/18.
 */
public class MapStrategy extends Strategy {
    Map<Integer, Integer> map;

// try treemap as well
    MapStrategy(DataStructure ds, DataStructure ds2){
        super(ds);
        switch(ds2) {
            case HASHMAP: this.map = new HashMap<>();
                break;
            case TREEMAP: this.map = new TreeMap<>();
                break;
            case HASHTABLE: this.map = new Hashtable<>();
                break;
            default:
                break;
        }
        System.out.println(this.map.getClass());
    }
    public void append(int[] list){
        Instant beg = Instant.now();
        for (int i: list){
            super_array.add(i);
        }
        //System.out.println(this.super_array); // check array appending
        Instant end = Instant.now();
        findSums();


        prev_size = super_array.size();

    }
    public boolean contains(Integer n){
        Instant beg = Instant.now();
       // System.out.println("fast sums_list: "+l);
        if (map.containsKey(n)){return true;
        }
        return false;
    }
    public void findSums(){
        Instant beg = Instant.now();
        int index = prev_size-2 > 0 ? prev_size-2 : 0;
        while (index < super_array.size()-2) {
            int sum = super_array.get(index) + super_array.get(index+1) + super_array.get(index+2);
            int check = (map.get(sum) == null) ? 0 : map.get(sum) ;
            if (check == 0){
                map.put(sum, 1);
            }
            else {
                map.put(sum, check++);

            }
            index++;
        }


        Instant end = Instant.now();
        this.duration_sum = Duration.between(beg,end);
        //System.out.println("Fast Map sums_list: "+map); // check for sums_list, vals in map
    }
    public String getDataStructureName(){
        //Pattern p = Pattern.compile(".+?\\..+?\\.(\\w)");
        //Matcher m = p.matcher(String.valueOf(map.getClass()));
        String regex = "util.";
        String[] strarr = String.valueOf(this.map.getClass()).split(regex);
        return super.getDataStructureName() +" "+strarr[1];

    }
}


