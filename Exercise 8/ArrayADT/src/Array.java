/**
 * Created by liangchun on 13.06.17.
 */
public interface Array<T> {
    void put(int pos, T x);
    int lower();
    int upper();
    T get(int pos);
    boolean empty();
}
