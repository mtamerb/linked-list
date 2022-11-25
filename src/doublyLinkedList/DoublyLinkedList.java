package doublyLinkedList;

public class DoublyLinkedList {
    class Node {
        int item;
        Node previous;
        Node next;

        public Node(int item) {
            this.item = item;
            this.previous = null;
            this.next = null;
        }
    }

    Node head, tail = null;

    public void addNode(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void printNodes() {
        Node current = head;
        if (current == null) {
            System.out.println("Doubly Linked List is empty");
            return;
        }
        System.out.println("Nodes of Doubly Linked List: ");
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(3);
        doublyLinkedList.addNode(5);
        doublyLinkedList.addNode(7);
        doublyLinkedList.addNode(9);
        doublyLinkedList.printNodes();
        doublyLinkedList.addNode(7);
        doublyLinkedList.addNode(9);
        doublyLinkedList.printNodes();
        System.out.println("head: " + doublyLinkedList.head.item +
                " tail: " + doublyLinkedList.tail.item);
    }

}


















