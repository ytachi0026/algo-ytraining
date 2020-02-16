package dev.ytachi.algorithms.list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        final Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));
        head.getNext().getNext().getNext().setNext(new Node(5));

        // Iterative
        final ReverseLinkedList worker = new ReverseLinkedList();
//        final Node reverseHead = worker.reverseLinkedList(head);

        // Recursive
        final Node reverseHead = worker.revertLinkedListRecursive(head, null);

        // let's print it
        worker.printer(reverseHead);
    }

    public void printer(final Node head) {
        Node printer = head;
        while (printer != null) {
            System.out.println("Node: " + printer.getValue());
            printer = printer.getNext();
        }
    }

    public Node revertLinkedListRecursive(Node current, Node prev) {

        Node head;
        // we reach the end of the list
        if (current.getNext() == null) {
            head = current;
            current.setNext(prev);
            return head;
        }

        Node next = current.getNext();
        current.setNext(prev);

        head = revertLinkedListRecursive(next, current);

        return head;
    }

    public Node reverseLinkedList(final Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        // We play with "pointer" hahaha, silly right? pointers in Java? come on man!
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        // We return the new head, which is? => that's right prev;
        return prev;
    }
}


class Node {
    private Integer value;
    private Node next;

    public Node(final Integer value) {
        this.value = value;
        this.next = null;
    }
    public Node(final Integer value, final Node next) {
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(final Node next) {
        this.next = next;
    }
}
