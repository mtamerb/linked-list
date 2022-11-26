package singlyLinkedList;

public class LinkedList {

    public Node head = null;

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    Node current, prev, temp;

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


    public void deleteFirstNode() {
        if (head != null) {
            head = head.next;
        }
    }

    public Node deleteLastNode() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            head = null;
            return null;
        }
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        return head;
    }

    public void findNode(int item) {
        boolean found = false;
        int pos = 0;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (head != null) {
                if (head.data == item) {
                    found = true;
                    break;
                }
                pos++;
                head = head.next;
            }
        }
        if (found) {
            System.out.println("item : " + item + " is present in the list at the index : " + pos);
        } else {
            System.out.println("item is not present in the list");
        }
    }

    public void deleteKeyNode(int key) {
        Node prev = null;
        temp = head;
        if (temp == null) {
            return;
        }
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
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
        LinkedList linkedList = new LinkedList();
        linkedList.addNodeAtTheBeginning(10);
        linkedList.addNodeAtTheEnd(20);
        linkedList.addNodeAtTheEnd(30);
        linkedList.addNodeAtTheEnd(40);
        linkedList.addNodeAtTheSpecificPosition(0, 15);
        linkedList.addNodeAtTheSpecificPosition(3, 50);
        linkedList.print();

    }

}
