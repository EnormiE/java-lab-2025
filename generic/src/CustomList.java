import java.util.AbstractList;

public class CustomList <T> extends AbstractList <T> {
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

    public boolean add(T t) {
        addTail(t);
        return true;
    }

    @Override
    public int size() {
        int size = 0;
        Node<T> currentNode = this.head;
        while (currentNode != null){
            size += 1;
            currentNode = currentNode.next;
        }
        return size;
    }

    @Override
    public T get(int index) {
        int id = 0;
        Node<T> currentNode = this.head;
        while (currentNode != null){
            if (index == id) {
                return (T) currentNode.value;
            }
            id += 1;
            currentNode = currentNode.next;
        }
        throw new IndexOutOfBoundsException("Szukany index nie znajduje się na liście");
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
