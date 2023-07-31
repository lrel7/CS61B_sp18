public class ArrayDeque<T>{
    private T[] arr; // array to save data
    private int arr_len; // length of the arr
    private int size; // number of items in the deque
    private int front; // index of the front
    private int last; // index of the last

    public ArrayDeque(){
        arr = (T[])new Object[8]; // init an array of length 8
        arr_len = 8;
        size = 0;
        front = 0;
        last = 0;
    }

    private void grow(int capacity){
        T[] new_arr = (T[])new Object[capacity];
        System.arraycopy(arr, 0, new_arr, 0, arr_len);
        arr = new_arr;
        arr_len = capacity;
    }

    private int move_forward(int index){
        int mod = (index - 1) % arr_len;
        return mod < 0 ? mod + arr_len : mod;
    }

    private int move_backward(int index){
        return (index + 1) % arr_len;
    }

    public void addFirst(T item){
        if(arr_len == size){
            grow(arr_len * 3);
        }        
        front = move_forward(front);
        arr[front] = item;
        size ++;
    }

    public void addLast(T item){
        if(arr_len == size){
            grow(arr_len * 3);
        }        
        last = (last + 1) % arr_len;
        arr[last] = item;
        size ++;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int i = front;
        while(true){
            System.out.println(arr[i] + " ");
            if(i == last){
                break;
            }
            i = move_backward(i);
        }
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T ret = arr[front];
        front = move_backward(front);
        size --;
        return ret;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T ret = arr[last];
        last = move_forward(last);
        size --;
        return ret;
    }
    
    public T get(int index){
        if(size <= index){
            return null;
        }
        int pos = index;
        while(index > 0){
            pos = move_backward(pos);
            index --;
        }
        return arr[pos];
    }    
}
