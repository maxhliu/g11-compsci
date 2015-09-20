package victuals;

import java.util.ArrayList;

public class AStack {
    int[] myList;
//    ArrayList <Integer> myList;
    int top;
    AStack() {
//        myList = new ArrayList ();
        myList = new int[1000];
        top = 0;
    }
    boolean isEmpty() {
        return top==0;
    }

    int size() {
//        return myList.size();
        return myList.length;
    }
    int last() {
//        return myList.get(top);
        return myList[top];
    }
    void push(int i) {
//        myList.add(i);
        top++;
        myList[top] = i;
    }
    int pop() {
//       return myList.remove(top);
        top--;
        return myList[top+1];
    }
}
