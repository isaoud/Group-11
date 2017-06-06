import java.util.HashMap;

/**
 * Created by liangchun on 05.06.17.
 */
public class MyMap<K, V> implements Map<K, V> {
    public HashMap<K, V> map;
    MyMap() {
        this.map = new HashMap<>();
    }
    public void insert(K x, V y) {
        if (this.map.get(x) == null)
            this.map.put(x, y);
        else
            this.update(x, y);
    }
    public void update(K x, V y) {
        if (this.map.get(x) != null)
            this.map.put(x, y);
    }
    public V lookup(K x) {
        return this.map.get(x);
    }
    public void delete(K x) {
        if (this.map.get(x) != null)
            this.map.remove(x);
    }
    public void union(Map<K, V> x) {
        MyMap<K, V> temp = (MyMap<K, V>) x;
        temp.map.putAll(this.map);
        this.map = temp.map;
    }
    public boolean is_in_dom(K x) {
        return (this.map.containsKey(x)) ? true : false;
    }
    public int size() {
        return this.map.size();
    }
    public MyOption<V> lookup_opt(K x) {
        if (this.map.containsKey(x))
            return new MyOptionSome<>(this.map.get(x));
        return new MyOptionNone<>();
    }
}
