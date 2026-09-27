public interface MyQueue<T> {
    void enqueue(T item);
    T dequeue();
    T front();
    boolean isEmpty();
    int size();
    void delete(int n);
}