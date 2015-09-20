
package victuals;

public class Link {
    public Link nextLink;
    public int data1;
    public double data2;
    public Link(int d1, double d2) {
        data1 = d1;
        data2 = d2;
        nextLink = null;
    }
    public void printLink() {
        System.out.println("{" + data1 + "," + data2 + "} ");
    }
}
