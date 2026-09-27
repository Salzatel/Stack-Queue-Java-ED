public class SingleLinkedListWithTail<T> {
    public SingleNode<T> head;
    public SingleNode<T> tail; 

    public SingleLinkedListWithTail() {
        this.head = null;
        this.tail = null;
    }

    public boolean empty() {
        return head == null;
    }

    
    public void pushFront(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head; 
        }
    }

    
    public void popFront() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        head = head.next;
        if (head == null) {
            tail = null; 
        }
    }

    
    public void pushBack(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        if (empty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode; 
        }
    }

    
    public void popBack() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        if (head == tail) { 
            head = tail = null;
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next != tail) { 
            temp = temp.next;
        }
        temp.next = null;
        tail = temp; 
    }

    
    public SingleNode<T> find(T key) {
        SingleNode<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) return temp;
            temp = temp.next;
        }
        return null;
    }

    
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
                    tail = temp; 
                }
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    
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

    
    public void addAfter(SingleNode<T> node, T key) {
        if (node == null) return;
        SingleNode<T> newNode = new SingleNode<>(key);
        newNode.next = node.next;
        node.next = newNode;
        if (node == tail) {
            tail = newNode; 
        }
    }
}