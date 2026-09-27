public class DoubleLinkedListNoTail<T> {
    public DoubleNode<T> head;

    public DoubleLinkedListNoTail() {
        this.head = null;
    }

    public boolean empty() {
        return head == null;
    }

    // PushFront: O(1)
    public void pushFront(T key) {
        DoubleNode<T> newNode = new DoubleNode<>(key);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode; 
        }
        head = newNode;
    }

    // PopFront: O(1)
    public void popFront() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        head = head.next;
        if (head != null) {
            head.prev = null; 
        }
    }

    // PushBack: O(N) recorrer todo sin un tail
    public void pushBack(T key) {
        DoubleNode<T> newNode = new DoubleNode<>(key);
        if (empty()) {
            head = newNode;
            return;
        }
        DoubleNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp; 
    }

    // PopBack: O(N)
    public void popBack() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        if (head.next == null) {
            head = null;
            return;
        }
        DoubleNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null; 
    }

    // Find: O(N)
    public DoubleNode<T> find(T key) {
        DoubleNode<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) return temp;
            temp = temp.next;
        }
        return null;
    }

    
    public void erase(T key) {
        DoubleNode<T> node = find(key);
        if (node == null) return;
        
        if (node == head) {
            popFront();
            return;
        }
        
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
    }

    
    public void addBefore(DoubleNode<T> node, T key) {
        if (node == null) return;
        if (node == head) {
            pushFront(key);
            return;
        }
        DoubleNode<T> newNode = new DoubleNode<>(key);
        newNode.next = node;
        newNode.prev = node.prev;
        
        node.prev.next = newNode;
        node.prev = newNode;
    }

    
    public void addAfter(DoubleNode<T> node, T key) {
        if (node == null) return;
        DoubleNode<T> newNode = new DoubleNode<>(key);
        newNode.prev = node;
        newNode.next = node.next;
        
        if (node.next != null) {
            node.next.prev = newNode;
        }
        node.next = newNode;
    }
}