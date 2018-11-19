import java.util.*;



/**
 * Created by tomaszmichalik on 10/31/18.
 */
public class Test {
    Stack stack = new Stack();
    class Stack {

        private List<Integer> stack;
        // added for optimization outside of size() list interface
        private int size;
        class Node{
            Node prev;
        }
        Stack(){
            this.stack = new LinkedList<>();
            this.size = 0;
        }
        public int pop(){
            size--;
            return stack.get(0);

        }
        public void push(int num){
            stack.add(0,num);
            size++;
        }
        public void inc(int k, int e) {
            if (size ==0 || size < e){
                // throw index exc/order ex or just printout

                return;
            }
            ListIterator<Integer> iterator = stack.listIterator(size-e);
            while (iterator.hasNext()){

            }
        }
    }
    public static void main(String[] args) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new TreeMap<>();
        List<Integer> list = new ArrayList<>();

        //arr.
       // stack.push(1);
    }
}
