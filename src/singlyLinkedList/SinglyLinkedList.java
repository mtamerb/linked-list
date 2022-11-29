package singlyLinkedList;

public class SinglyLinkedList {

    public Node head = null;

    static class Node {
        private final int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    Node current, prev;

    public void addNodeAtTheBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addNodeAtTheEnd(int data) {
        Node newNode = new Node(data);
        current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void addNodeAtTheSpecificPosition(int position, int data) {
        if (position == 0) {
            System.out.println("Position must on or greater than 0");
            addNodeAtTheSpecificPosition(1, data);
            return;
        }
        System.out.println("Add a node with data " + data + " at the position " + position);
        Node newNode = new Node(data);
        current = this.head;
        prev = this.head;
        if (position == 1) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }
        while (current.next != null && --position > 0) {
            prev = current;
            current = current.next;
        }
        prev.next = newNode;
        newNode.next = current;

    }


    public void print() {
        current = this.head;
        if (current == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Nodes of singly linked list: ");
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("NULL\n");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addNodeAtTheBeginning(10);
        linkedList.addNodeAtTheEnd(20);
        linkedList.addNodeAtTheEnd(30);
        linkedList.addNodeAtTheEnd(40);
        linkedList.addNodeAtTheSpecificPosition(0, 15);
        linkedList.addNodeAtTheSpecificPosition(3, 50);
        linkedList.print();

    }

}
