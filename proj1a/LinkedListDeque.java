public class LinkedListDeque<T> {
    private class Node{
        private T item; // the item stored on this node
        private Node prev; // the node before
        private Node next; // the node after

        // constructor 
        public Node(T item_, Node prev_, Node next_){
            item = item_;
            prev = prev_;
            next = next_;
        }
    } 

    private int size; // number of items
    private Node sentinel; // circular sentinel

    // constructor
    public LinkedListDeque(){
        size = 0;
        sentinel = new Node(null, null ,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel; 
    }

    // add an item to the front of the deque
    public void addFirst(T item){
        Node new_node = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = new_node;
        sentinel.next = new_node;
        size ++; 
    }

    // add an item to the back of the deque
    public void addLast(T item){
        Node new_node = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = new_node;
        sentinel.prev = new_node;
        size ++;
    }

    // if the deque is empty or not
    public boolean isEmpty(){
        return size == 0;
    }

    // get the size of the deque
    public int size(){
        return size;
    }

    // print the items in the deque from first to last, seperated by a space
    public void printDeque(){
        Node ptr = sentinel.next;
        while(ptr != sentinel){
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    // removes and returns the item at the front of the deque, returns null if the deque is empty
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size --;
        return first;
    }

    // removes and returns the item at the end of the deque, returns null if the deque is empty
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size --;
        return last;
    }

    // get the item at the given index, 0 refers to the front, 1 refers to its next, and so on
    // returns null if no such index
    public T get(int index){
        if(size <= index){
            return null;
        }
        Node ptr = sentinel.next;
        while(index > 0){
            ptr = ptr.next;
            index --;
        }
        return ptr.item;
    }
}
