package victuals;

public class AQueue {

    int myList[];
    int first;
    int last;

    AQueue(int s) {
        myList = new int[s];
        first = -1;
        last = -1;
    }

    boolean isEmpty() {
        return first == -1 && last == -1;
    }

    int size() {
        if (first > last) {
            first -= myList.length;
        }
        return last - first + 1;
    }

    int front() {
        return myList[first];
    }

    int back() {
        return myList[last];
    }

    void push(int n) {
        if (first == -1) {
            first++;
        }
        if (last + 1 >= myList.length) {
            last -= myList.length;
        }
        myList[++last] = n;
    }

    int pop() {
        if (this.isEmpty()) {
            return 0;
        }
        int r = myList[first];
        if (first == last) {
            first = -1;
            last = -1;
        } else {
            ++first;
        }
        if (first >= myList.length) {
            first -= myList.length;
        }
        return r;
    }

    void print() {
        if (first >= 0) {
            if (first <= last) {
                for (int i = 0; i < first; i++) {
                    System.out.print("X");
                }
                for (int i = first; i <= last; i++) {
                    System.out.print(myList[i]);
                }
                for (int i = last + 1; i < myList.length; i++) {
                    System.out.print("X");
                }
            } else {
                for (int i = 0; i <= last; i++) {
                    System.out.print(myList[i]);
                }
                for (int i = last + 1; i < first; i++) {
                    System.out.print("X");
                }
                for (int i = first; i < myList.length; i++) {
                    System.out.print(myList[i]);
                }
            }
        } else {
            System.out.print("Empty Queue");
        }
        System.out.println("");
    }
}
