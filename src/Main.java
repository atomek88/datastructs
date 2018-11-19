import java.util.*;
import java.time.*;
public class Main {

    static final String filename = "../results.txt";
    // add threads?

    // add method/design patters which chooses which strategy to implement based on the parameter passed to it
   // private static void runStrategy(Strategy strat){


    public static void main(String[] args) {
        System.out.println("Strategy training of design patterns, input 1st for Array size:");

        Main m = new Main();
        FileSaver fileSaver = new FileSaver(filename);

        // scan for user input, refactor later
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        System.out.println("Enter parameters for lower and upper bound for numbers in array:");
        int lower_b = sc.nextInt();
        int upper_b = sc.nextInt();
        System.out.println("Enter Data Structure to be used:");
        String struct = sc.next(); // data structure object
        System.out.println("Thank you, processing your results...");
        // scan in parameters of array for initial append to strategy object
        //**** refactor to separate module for creation of strategy from user input


        // add way to scan in numbers , file read or scanner
        int[] array = new Random().ints(size, lower_b, upper_b).toArray();
        // start strategies

        Strategy al_al_strat = new ListStrategy(Strategy.DataStructure.ARRAYLIST,Strategy.DataStructure.ARRAYLIST);
        Strategy ll_al_strat = new ListStrategy(Strategy.DataStructure.LINKEDLIST,Strategy.DataStructure.ARRAYLIST);
        //use vector if threads -Strategy vec_al_strat = new ListStrategy(Strategy.DataStructure.VECTOR, Strategy.DataStructure.ARRAYLIST);
       // Strategy stack_strat = new ListStrategy(Strategy.DataStructure.STACK); implement later along with deque

        Strategy al_hmap_strat = new MapStrategy(Strategy.DataStructure.ARRAYLIST,Strategy.DataStructure.HASHMAP);
        Strategy al_htable_strat = new MapStrategy(Strategy.DataStructure.ARRAYLIST,Strategy.DataStructure.HASHTABLE);
        Strategy al_tmap_strat = new MapStrategy(Strategy.DataStructure.ARRAYLIST,Strategy.DataStructure.TREEMAP);
       // Strategy stack_strat = new MapStrategy(Strategy.DataStructure.LINKEDLIST,Strategy.DataStructure.ARRAYLIST);
        Strategy al_tset_strat = new SetStrategy(Strategy.DataStructure.ARRAYLIST,Strategy.DataStructure.TREESET);
        Strategy al_hset_strat = new SetStrategy(Strategy.DataStructure.ARRAYLIST,Strategy.DataStructure.HASHSET);
      //  Strategy vector_strat = new MapStrategy(Strategy.DataStructure.LINKEDLIST,Strategy.DataStructure.ARRAYLIST);
      //  Strategy stack_strat = new MapStrategy(Strategy.DataStructure.LINKEDLIST,Strategy.DataStructure.ARRAYLIST);

/*
        runStrategy(al_al_strat, array, fileSaver);

        runStrategy(ll_al_strat, array, fileSaver);
        runStrategy(al_hmap_strat, array, fileSaver);
        runStrategy(al_htable_strat, array, fileSaver);
        runStrategy(al_tmap_strat, array, fileSaver);
        runStrategy(al_tset_strat, array, fileSaver);
        runStrategy(al_hset_strat, array, fileSaver);
*/


    }
// static method in main runs the strategy
    // refactor into interface like 1 function which takes type of strat/algo and types of data structures and runs correct algo
    private static void runStrategy(Strategy strat, int[] arr, FileSaver f) {
        Instant beg = Instant.now();
        strat.append(arr);
        System.out.println("21 "+strat.contains(21));
        System.out.println("10 "+strat.contains(88));
        System.out.println("28 "+strat.contains(38));
        int size = strat.super_array.size();
        int[] array = new Random().ints(size/2, 0, 99).toArray();
        strat.append(array);
        System.out.println("6 "+strat.contains(67));
        System.out.println("13 "+strat.contains(13));
        System.out.println("21 "+strat.contains(21));
        System.out.println("10 "+strat.contains(10));
        System.out.println("28 "+strat.contains(28));
        System.out.println("34 "+strat.contains(134));

        Instant end = Instant.now();
        Duration dur = (Duration.between(beg,end));
        //String forma = "| %s$-20s  %";
        String type = strat.toString() +" "+ strat.getDataStructureName() +" ";
       // f.writetoFile(type);
        System.out.println(type);
        int totalsize = (size+(size/2) );
       // String format = "| %s$-20s || ";
        String times = "N:"+ totalsize+ " || ";
       // String result = format.concat(type).concat()
        String ex =  "execution time(ms):"+dur.toMillis() + " || (ns):"+dur.toNanos();
        f.writetoFile(type+times+ex);
        System.out.println(times+ex); //.toMillis() for milliseconds

    }


}
