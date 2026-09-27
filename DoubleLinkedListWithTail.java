public class DoubleLinkedListWithTail<T> {
    public DoubleNode<T> head;
    public DoubleNode<T> tail; 

    public DoubleLinkedListWithTail() {
        this.head = null;
        this.tail = null;
    }

    public boolean empty() {
        return head == null;
    }

    
    public void pushFront(T key) {
        DoubleNode<T> newNode = new DoubleNode<>(key);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode; 
        }
        head = newNode;
    }

    
    public void popFront() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; 
        }
    }

    
    public void pushBack(T key) {
        DoubleNode<T> newNode = new DoubleNode<>(key);
        if (empty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
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
        tail = tail.prev;
        tail.next = null; 
    }

    
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
        if (node == tail) {
            popBack();
            return;
        }

        
        node.next.prev = node.prev;
        node.prev.next = node.next;
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
        if (node == tail) {
            pushBack(key);
            return;
        }
        DoubleNode<T> newNode = new DoubleNode<>(key);
        newNode.prev = node;
        newNode.next = node.next;
        
        node.next.prev = newNode;
        node.next = newNode;
    }
}