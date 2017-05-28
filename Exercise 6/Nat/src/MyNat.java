/**
 * Created by liangchun on 28.05.17.
 */
class MyNat<T> implements Nat<T> {
    public int x;
    MyNat(int x) {
        this.x = x;
    }
    public MyNat<T> succ() {
        return new MyNat(++this.x);
    }
    public MyNat<T> pred() {
        int z = this.x - 1;
        if (z >= 0) {
            return new MyNat(z);
        } else {
            return new MyNat(0);
        }
    }
    public boolean less(Nat<T> x) {
        MyNat<T> t = (MyNat<T>) x;
        return this.x < t.x;
    }
    public MyNat<T> add(Nat<T> x){
        MyNat<T> t = (MyNat<T>) x;
        return new MyNat(this.x + t.x);
    }
    public MyNat<T> mult(Nat<T> x){
        MyNat<T> t = (MyNat<T>) x;
        return new MyNat(this.x * t.x);
    }
    public String toString() {
        return "x: "+this.x;
    }
}