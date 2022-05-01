package datastructure;

import java.util.Scanner;
import java.util.Stack;

public class QueueTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<E>{
    private final Stack<E> inbox = new Stack<>();
    private final Stack<E> outbox = new Stack<>();

    public void enqueue(E i){
        inbox.push(i);
    }

    public E dequeue(){
        if(outbox.isEmpty()){
            while(!inbox.isEmpty()){
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

    public E peek(){
        if(outbox.isEmpty()){
            while(!inbox.isEmpty()){
                outbox.push(inbox.pop());
            }
        }
        return outbox.peek();
    }

}
