package src.linkedlist;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        // create newn o de
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        // head=newnode
        head = newNode;

    }

    public void addLast(int data) {
        // create newnode
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // tail.next->newnode
        tail.next = newNode;
        // tail=newNode
        tail = newNode;
    }

    public static void printll() {
        Node temp = head;
        if (head == null) {
            System.out.println("ll is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    public void addmiddle(int idx, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        printll();

    }

}
