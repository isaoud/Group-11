public class MyOptionNone<T> implements MyOption<T> {
    public MyOptionNone() {}
    
    public T the() {
        assert false : "Precondition not satisfied";
        throw new IllegalStateException();
    }

    public String toString() {
        return "none";
    }
}