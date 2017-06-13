/**
 * Created by liangchun on 13.06.17.
 */
import java.util.ArrayList;

public class MyArray<T> implements Array<T> {
    public ArrayList<T> arr;
    public int i;
    public int j;

    MyArray(int i, int j) {
        this.arr = new ArrayList<T>(j);
        for (int x = 0; x < i; x++) {
            this.arr.add(null);
        }
        for (int x = i; x <= j; x++) {
            this.arr.add(null);
        }
        this.i = i;
        this.j = j;
    }

    public int lower() {
        return this.i;
    }

    public int upper() {
        return this.j;
    }

    public T get(int pos) {
        if (pos < this.i) return null;
        return this.arr.get(pos);
    }

    public boolean empty() {
        for (int i = 0; i <= this.j; i++) {
          if(this.arr.get(i) != null)
              return false;
        }
        return true;
    }

    public void put(int i, T x) {
        if (i > this.j || i < this.i) return;
        this.arr.set(i, x);
    }

    public String toString() {
        ArrayList<T> clone = (ArrayList<T>)this.arr.clone();
        for (int i = this.i - 1; i >= 0; i--) {
            clone.remove(i);
        }
        return clone.toString();
    }
}
