public class SingleLinkedListNoTail<T> {
    public SingleNode<T> head;

    
    public SingleLinkedListNoTail() {
        this.head = null;
    }

    
    public boolean empty() {
        return head == null;
    }

    
    public void pushFront(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        newNode.next = head;
        head = newNode;
    }

    
    public void popFront() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        head = head.next;
    }

    
    public void pushBack(T key) {
        SingleNode<T> newNode = new SingleNode<>(key);
        if (empty()) {
            head = newNode;
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next != null) { 
            temp = temp.next;
        }
        temp.next = newNode;
    }

    
    public void popBack() {
        if (empty()) {
            throw new RuntimeException("La lista está vacía");
        }
        if (head.next == null) { 
            head = null;
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null; 
    }

    
    public SingleNode<T> find(T key) {
        SingleNode<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) {
                return temp;
            }
            temp = temp.next;
        }
        return null; 
    }

   
    public void erase(T key) {
        if (empty()) return;
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }
        SingleNode<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(key)) {
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
    }
}