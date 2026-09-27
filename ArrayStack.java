public class ArrayStack<T> implements MyStack<T> {
    private T[] array;
    private int top; // Índice del último elemento insertado
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = (T[]) new Object[capacity];
        this.top = -1; // -1 significa que está vacía
    }

    @Override
    public void push(T item) {
        if (size() == capacity) {
            resize(capacity * 2); // Duplicar tamaño (O(N) ocasional, O(1) amortizado)
        }
        array[++top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("La pila está vacía");
        T item = array[top];
        array[top] = null; // Evitar fugas de memoria
        top--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("La pila está vacía");
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    // Retira 'n' elementos de la pila
    @Override
    public void delete(int n) {
        if (n > size()) n = size();
        for (int i = 0; i < n; i++) {
            pop();
        }
    }

    // Método para expandir dinámicamente el arreglo
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
    }
}