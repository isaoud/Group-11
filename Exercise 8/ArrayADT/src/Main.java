/**
 * Created by liangchun on 13.06.17.
 */
public class Main {
    public static void main(String args[]) {
        // Create Array[T] with type String and bounds 2 to 5
        MyArray<String> x = new MyArray<>(2, 5);

        // Insert two elements
        x.put(2, "ONE");
        x.put(3, "TWO");

        // Print the array
        System.out.println(x);

        // Check if it's empty
        System.out.println(x.empty());

        // Get element at position two
        System.out.println(x.get(2));

        // Get lower and upper bounds
        System.out.println("Lower bounds: " + x.lower());
        System.out.println("Upper bounds: " + x.upper());

        // Out of range put
        x.put(6, "INVALID ELEMENT");
        // Nothing will show in this println statement
        System.out.println(x);

    }
}
