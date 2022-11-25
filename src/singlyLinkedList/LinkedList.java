package singlyLinkedList;

public class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    Node current, index, temp;

    public void removeDuplicateNodes() {
        current = head;
        index = null;
        temp = null;
        if (head == null) {
            return;
        } else {
            while (current != null) {
                temp = current;
                index = current.next;
                while (index != null) {
                    if (current.data == index.data) {
                        temp.next = index.next;
                    } else {
                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
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
        Node current = head;
        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList listDuplicate = new LinkedList();
        listDuplicate.addNode(1);
        listDuplicate.addNode(2);
        listDuplicate.addNode(3);
        listDuplicate.addNode(4);
        listDuplicate.addNode(5);
        listDuplicate.addNode(6);
        listDuplicate.addNode(7);
        listDuplicate.addNode(4);
        listDuplicate.addNode(5);
        listDuplicate.addNode(6);
        listDuplicate.addNode(7);
        listDuplicate.addNode(4);
        listDuplicate.addNode(5);
        listDuplicate.addNode(6);
        listDuplicate.addNode(7);
        System.out.println("Original List : ");
        listDuplicate.print();
        listDuplicate.removeDuplicateNodes();
        System.out.println("List after removing duplicates : ");
        listDuplicate.print();
        listDuplicate.deleteKeyNode(3);
        System.out.println("List after delete specific node : ");
        listDuplicate.print();
    }

}
