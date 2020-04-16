import java.util.LinkedList;

public class MyStack {
    LinkedList<Integer> list;
    LinkedList<Integer> help;
    int top = -1;
    int size = 0;

    /** Initialize your data structure here. */
    public MyStack() {
        list = new LinkedList<>();
        help = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        if (help.isEmpty()) list.push(x);
        else help.addFirst(x);
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (size == 0) return -1;
        if (help.isEmpty()){
            while (list.size() > 1){
                if (list.size() == 2) top = list.getLast();
                else top = -1;
                help.addFirst(list.removeLast());
            }
            size--;
            return list.removeLast();
        }
        else {
            while (help.size() > 1){
                if (help.size() == 2) top = help.getLast();
                else top = -1;
                list.addFirst(help.removeLast());
            }
            size--;
            return help.removeLast();
        }
    }

    /** Get the top element. */
    public int top() {
        if (size == 0) return -1;
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }
}
