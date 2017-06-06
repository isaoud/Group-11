/**
 * Created by liangchun on 05.06.17.
 */
public class Main {
    public static void main(String args[]) {
        MyMap<String, Integer> x = new MyMap<>();

        // insert
        x.insert("s", 2);
        System.out.println("Lookup s in x: " + x.lookup("s"));

        // delete
        x.insert("delete", 123);
        x.delete("delete");
        x.delete("delete");
        System.out.println("Deleted key-value pair 'delete' from map");

        // lookup
        System.out.println("Lookup 'delete' in x: " + x.lookup("delete"));

        // is_in_dom
        System.out.println("Check if delete is_in_dom in x: " + x.is_in_dom("delete"));

        // update
        x.update("s", 999);
        System.out.println("Update s to 999: " + x.map);

        // union
        MyMap<String, Integer> y = new MyMap<>();
        y.insert("Key", 24);
        y.union(x);
        System.out.println("Union map of y with x: " + y.map);

        // size
        System.out.println("Size of x: " + x.size());
    }
}
