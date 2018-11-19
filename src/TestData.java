import java.util.*;
/**
 * Created by tomaszmichalik on 10/31/18.
 */
public class TestData {

    public static void main(String[] args) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new TreeMap<>();
        Map<Integer, Integer> m3 = new Hashtable<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new Vector<>();
        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new HashSet<>();
        // objects
        List<Object> objs = new ArrayList<>();
        objs.add(m1); objs.add(m2); objs.add(m3); objs.add(s1); objs.add(s2); objs.add(l1); objs.add(l2); objs.add(l3);
        String st = "word";

        // run function on object
        for (Object o : objs){
            System.out.println(o.getClass());
        }
    }
    // public static test function to use diff structures
    public static void function(List<Integer> list){

    }
}
