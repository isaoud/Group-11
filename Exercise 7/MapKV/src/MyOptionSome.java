public class MyOptionSome<T> implements MyOption<T> {
    public T t;

    public MyOptionSome(T t) {
        this.t = t;
    }
    
    public T the() {
        return t;
    }

    public String toString() {
        return "some("+t+")";
    }
}