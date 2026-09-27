public class SingleLinkedListNoTail<T> {
    public SingleNode<T> head;

    // Constructor: Inicialmente la lista está vacía
    public SingleLinkedListNoTail() {
        this.head = null;
    }

    // Método Empty
    public boolean empty() {
        return head == null;
    }

    // PushFront: Agrega un nodo al inicio. Complejidad: O(1)
    public void pushFront(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        newNode.next = head;
        head = newNode;
    }

    // PopFront: Elimina el primer nodo. Complejidad: O(1)
    public void popFront() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        head = head.next;
    }

    // PushBack: Agrega al final. Complejidad: O(N) porque hay que recorrer todo
    public void pushBack(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        if (empty()) {
            head = newNode;
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next != null) { // Recorremos hasta el final
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // PopBack: Elimina el último nodo. Complejidad: O(N)
    public void popBack() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        if (head.next == null) { // Si solo hay un elemento
            head = null;
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next.next != null) { // Buscamos el penúltimo nodo
            temp = temp.next;
        }
        temp.next = null; // Desconectamos el último
    }

    // Find: Busca un valor y retorna el nodo. Complejidad: O(N)
    public SingleNode<T> find(T key) {
        SingleNode<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // Retorna null si no lo encuentra
    }

    // Erase: Elimina un nodo por su valor. Complejidad: O(N)
    public void erase(T key) {
        if (empty()) return;
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(key)) {
                temp.next = temp.next.next; // Saltamos el nodo para borrarlo
                return;
            }
            temp = temp.next;
        }
    }

    // AddBefore: Agrega un elemento antes de un nodo dado. Complejidad: O(N)
    public void addBefore(SingleNode<T> node, T key) {
        if (empty() || node == null) return;
        if (head == node) {
            pushFront(key);
            return;
        }
        SingleNode<T> temp = head;
        while (temp != null && temp.next != node) { // Buscamos el nodo anterior
            temp = temp.next;
        }
        if (temp != null) {
            SingleNode<T> newNode = new SingleNode<>(key);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // AddAfter: Agrega un elemento después de un nodo dado. Complejidad: O(1)
    public void addAfter(SingleNode<T> node, T key) {
        if (node == null) return;
        SingleNode<T> newNode = new SingleNode<>(key);
        newNode.next = node.next;
        node.next = newNode;
    }
}