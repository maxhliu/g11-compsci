package victuals;

public class LinkedList {

    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addLast(int d1, double d2) {
        if (first == null) {
            first = new Link(d1, d2);
        } else {
            Link pLink = new Link(d1, d2);
            Link theLink = first;
            while (theLink != null) {
                pLink = theLink;
                theLink = theLink.nextLink;
            }
            pLink.nextLink = new Link(d1, d2);
        }
    }

    public void addFirst(int d1, double d2) {
        if (first == null) {
            first = new Link(d1, d2);
        } else {
            Link theLink = first;
            first = new Link(d1, d2);
            first.nextLink = theLink;
        }
    }

    public void printList() {
        Link theLink = first;
        while (theLink != null) {
            theLink.printLink();
            theLink = theLink.nextLink;
        }
        System.out.println("");
    }

    public Link deleteFirst() {
        Link temp = first;
        if (first == null) {
            first = null;
        } else if (first.nextLink != null) {
            first = first.nextLink;
        } else {
            first = null;
        }
        return temp;
    }

    public Link deleteLast() {
        if (first == null) {
            return first;
        }
        if (first.nextLink == null) {
            Link temp = first;
            first = null;
            return temp;
        }
        Link pLink = null;
        Link theLink = first;
        while (theLink.nextLink != null) {
            pLink = theLink;
            theLink = theLink.nextLink;
        }
//        theLink = pLink;
        pLink.nextLink = null;
        return theLink;
    }
}
