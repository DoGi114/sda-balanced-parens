import java.sql.Array;
import java.util.*;

public class Main {
    private static final String OPENING_PARENTIS = "[\\(\\{\\[]";
    private static final String CLOSING_PARENTIS = "[\\)\\}\\]]";


    public static void main(String[] args) {
//        System.out.println(balancedParens("(())"));
//        System.out.println(balancedParens("(()))"));
//        System.out.println(balancedParens("(()))(("));
//        System.out.println(balancedParens("((())"));
//        System.out.println(balancedParens(")())"));
//        System.out.println(balanceAnyParens("{([])"));
//        System.out.println(balanceAnyParens("{([])}"));
//        System.out.println(balanceAnyParens("}([])}"));
//        System.out.println(balanceAnyParens("[(])"));
//        Deque<String> deque = new ArrayDeque<>();
//        deque.add("a");
//        deque.add("b");
//        deque.add("c");
//        deque.add("d");
//        reversQueue(deque);
//        System.out.println(Arrays.toString(deque.toArray()));
        int[] arr = {5,7,3,4,1,7,4,9,2};
//        Searcher search = new Searcher();
//        int i = search.GenericBinarySearch(arr, 5);
//        System.out.println(i);
        Sorter sorter = new Sorter();
        sorter.selectionSort(arr, false);
        System.out.println(Arrays.toString(arr));
    }

    private static boolean balancedParens(String s){
        String[] chars = s.split("");
        Stack<String> stack = new Stack<>();

        for(String c : chars){
            if("(".equals(c)){
                stack.push(c);
            }else if(")".equals(c)){
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.peek().equals("(")){
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean balanceAnyParens(String s){
        String[] chars = s.split("");
        Stack<String> stack = new Stack<>();

        for(String c : chars){

            if(OPENING_PARENTIS.matches(c)){
                stack.push(c);
            }else if(CLOSING_PARENTIS.matches(c)){
                if(stack.isEmpty()) {
                    return false;
                }

                String paren;

                switch (c){
                    case ")" : paren = "\\("; break;
                    case "]" : paren = "\\["; break;
                    case "}" : paren = "\\{"; break;
                    default: paren = "";
                }

                if(stack.peek().matches(paren)){
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    private static <T> void reversQueue(Deque<T> queue){
        // Revers queue only with pool, offer, peek and isEmpty
        // peak/poll -> head
        // offer -> tail
        //a b c d > b c d a
        //b c d a
        //c d a b
        //d a b c
        //a b c d...

        //D C B A

        if(queue.isEmpty())
            return;

        T item = queue.poll();

        reversQueue(queue);

        queue.offer(item);
    }
}
