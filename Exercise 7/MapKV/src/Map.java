/**
 * Created by liangchun on 05.06.17.
 */
public interface Map<K, V> {
    void insert(K x, V y);
    void update(K x, V y);
    boolean is_in_dom(K x);
    V lookup(K x);
    MyOption<V> lookup_opt(K x);
    void delete(K x);
    void union(Map<K, V> x);
    int size();
}
