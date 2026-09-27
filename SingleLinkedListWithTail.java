public class SingleLinkedListWithTail<T> {
    public SingleNode<T> head;
    public SingleNode<T> tail; // <-- Aquí está el nuevo apuntador

    public SingleLinkedListWithTail() {
        this.head = null;
        this.tail = null;
    }

    public boolean empty() {
        return head == null;
    }

    // PushFront: Sigue siendo O(1)
    public void pushFront(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head; // Si estaba vacía, head y tail son el mismo
        }
    }

    // PopFront: Sigue siendo O(1)
    public void popFront() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        head = head.next;
        if (head == null) {
            tail = null; // Si la lista quedó vacía, tail también debe ser null
        }
    }

    // PushBack: ¡AHORA ES O(1)! Gracias al tail no usamos ciclos
    public void pushBack(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        if (empty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode; // Actualizamos el tail al nuevo último
        }
    }

    // PopBack: Sigue siendo O(N) porque no sabemos quién es el penúltimo nodo
    public void popBack() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        if (head == tail) { // Solo hay un elemento
            head = tail = null;
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next != tail) { // Recorremos hasta el penúltimo
            temp = temp.next;
        }
        temp.next = null;
        tail = temp; // El penúltimo ahora es el tail
    }

    // Find: O(N)
    public SingleNode<T> find(T key) {
        SingleNode<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Erase: O(N)
    public void erase(T key) {
        if (empty()) return;
        if (head.data.equals(key)) {
            popFront();
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(key)) {
                if (temp.next == tail) { 
                    tail = temp; // Si borramos el último, debemos actualizar el tail
                }
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // AddBefore: O(N)
    public void addBefore(SingleNode<T> node, T key) {
        if (empty() || node == null) return;
        if (head == node) {
            pushFront(key);
            return;
        }
        SingleNode<T> temp = head;
        while (temp != null && temp.next != node) {
            temp = temp.next;
        }
        if (temp != null) {
            SingleNode<T> newNode = new SingleNode<>(key);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // AddAfter: O(1)
    public void addAfter(SingleNode<T> node, T key) {
        if (node == null) return;
        SingleNode<T> newNode = new SingleNode<>(key);
        newNode.next = node.next;
        node.next = newNode;
        if (node == tail) {
            tail = newNode; // Si insertamos después del último, el nuevo es el tail
        }
    }
}