/**
 * Created by liangchun on 28.05.17.
 */
public interface Nat<T> {
    Nat<T> succ();
    Nat<T> pred();
    boolean less(Nat<T> x);
    Nat<T> add(Nat<T> x);
    Nat<T> mult(Nat<T> x);
}