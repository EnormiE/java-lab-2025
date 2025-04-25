public class CustomList <T> {
    static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) {
            this.value = value;
        }
    }

    Node<T> head;
    Node<T> tail;

    public CustomList() {
        this.head = null;
        this.tail = null;
    }

    public void addHead(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.head != null) {
            newNode.next = this.head;
            this.head = newNode;
        }
        else {
            this.head = newNode;
            this.tail = this.head;
        }
    }

    public void addTail(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        }
        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public T getTail() {
        if (this.head == null) {
            throw new IllegalStateException("List is empty");
        }
        else {
            return (T) this.tail.value;
        }
    }

    public T getHead() {
        if (this.head == null) {
            throw new IllegalStateException("List is empty");
        }
        else {
            return (T) this.head.value;
        }
    }

    public T removeHead() {
        if (this.head == null) {
            throw new IllegalStateException("List is empty");
        }
        T returnValue = (T) this.head.value;
        this.head = this.head.next;
        return (T) returnValue;
    }

    public T removeTail() {
        if (this.head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (this.head == this.tail) {
            T returnValue = (T) this.tail.value;
            this.head = null;
            this.tail = null;
            return (T) returnValue;
        }
        Node <T> currentNode = this.head;
        while (currentNode.next != this.tail) {
            currentNode = currentNode.next;
        }
        T returnValue = (T) this.tail.value;
        this.tail = currentNode;
        this.tail.next = null;
        return returnValue;
    }

    @Override
    public String toString(){
        String result = "[ ";
        Node<T> currentNode = this.head;
        while (currentNode != null){
            result += currentNode.value;
            if (currentNode.next != null){
                result += ", ";
            }
            currentNode = currentNode.next;
        }
        result += " ]";
        return result;
    }
}
