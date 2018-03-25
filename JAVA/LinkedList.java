
class Node {
  int data;
  Node next;

  Node(int data) { this.data = data; }

  Node() {}
}
public class LinkedList {

  Node root;

  void add(int data) {
    if (root == null) {
      root = new Node(data);
    } else {
      Node newNode = new Node(data);
      Node temp = root;
      Node current = null;
      while (temp != null) {
        current = temp;
        temp = temp.next;
      }
      current.next = newNode;
    }
  }

  void print() {
    Node temp = root;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  public static void main(String[] args) {

    LinkedList list = new LinkedList();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    list.print();
  }
}