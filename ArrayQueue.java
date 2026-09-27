public class ArrayQueue<T> implements MyQueue<T> {
    private T[] array;
    private int front; 
    private int rear;  
    private int count; 
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    @Override
    public void enqueue(T item) {
        if (count == capacity) {
            resize(capacity * 2); 
        }
        rear = (rear + 1) % capacity; 
        array[rear] = item;
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("La cola está vacía");
        T item = array[front];
        array[front] = null; 
        front = (front + 1) % capacity; 
        count--;
        return item;
    }

    @Override
    public T front() {
        if (isEmpty()) throw new RuntimeException("La cola está vacía");
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void delete(int n) {
        if (n > count) n = count;
        for (int i = 0; i < n; i++) {
            dequeue();
        }
    }

    
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[(front + i) % capacity];
        }
        array = newArray;
        front = 0;
        rear = count - 1;
        capacity = newCapacity;
    }
}