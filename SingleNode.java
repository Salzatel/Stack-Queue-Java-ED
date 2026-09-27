public class SingleNode<T> {
    public T data;
    public SingleNode<T> next;

    public SingleNode(T data) {
        this.data = data;
        this.next = null;
    }
}