package com.example.myapplication;

public class SingleLinkedReverse {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SingleLinkedReverse slr = new SingleLinkedReverse();
        Node head, tail;
        head = tail = slr.new Node(0);
        for (int i = 1; i < 10; i++) {
            Node p = slr.new Node(i);
            tail.next = p;
            tail = p;
        }
        tail = head;
        while (tail != null) {
            System.out.print(tail.data+"  ");
            tail = tail.next;
        }

        System.out.println(" ");

        head = reverse1(head);
        while (head != null) {
            System.out.print(head.data + "  ");
            head = head.next;
        }

    }

    private static Node reverse(Node head) {
        Node p1, p2 = null;
        p1 = head;

        while (head.next != null) {
            p2 = head.next;
            head.next = p2.next;
            p2.next = p1;
            p1 = p2;
        }
        return p2;
    }

    private static Node reverse1(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
}
