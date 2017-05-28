/**
 * Created by liangchun on 28.05.17.
 */
public class Main {
    public static void main(String args[]) {
        /* Create a new Nat */
        MyNat<Integer> g = new MyNat(0);
        System.out.println(g);

        /* Increment the Nat by one */
        g = g.succ();
        System.out.println(g);

        /* Decrement the Nat by one */
        g = g.pred();
        System.out.println(g);

        /* Increment the Nat by three */
        g = g.succ().succ().succ();
        System.out.println(g);

        /* Output the product of the Nat and 10 */
        System.out.println(g.mult(new MyNat(10)));
    }
}
