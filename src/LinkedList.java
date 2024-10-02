public class LinkedList {
    static class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    Node head;
    void addNode(int data){
        Node nn = new Node(data);
        Node p = head;
        if (head == null) {
            head = nn;
        }else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = nn;
        }
    }
    void deleteNode(int data){
        Node p = head;
        if (head == null) {
            System.out.println("List is empty");
        }
        else {
            if (head.data == data) {
                head = head.next;
            }else{
                while (p.next.data != data) {
                    p = p.next;
                }
                p.next = p.next.next;
            }
        }
    }
    void printList(){
        Node p = head;
        System.out.println("---Start of List---");
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println("----End of List----");
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.deleteNode(5);
        list.deleteNode(1);
        list.printList();
    }
}
