import java.util.Stack;

class Node {
  int val;
  Node next;

  Node(int val) { this.val = val; }

  Node() {}
}

public class LinkedList {

  Node root;

  void add(int val) {
    if (root == null) {
      root = new Node(val);
    } else {
      Node newNode = new Node(val);
      Node temp = root;
      Node current = null;
      while (temp != null) {
        current = temp;
        temp = temp.next;
      }
      current.next = newNode;
    }
  }

  void add(int val, int position) {
    Node tmp, newNode;
    newNode = new Node(val);
    if (position == 0) {
      if (root == null) {
        root = newNode;
      } else {
        tmp = newNode;
        tmp.next = root;
        root = tmp;
      }
    } else {
      tmp = root;
      int count = 0;
      Node current = null;
      while (tmp != null && count < position) {
        count++;
        current = tmp;
        tmp = tmp.next;
      }
      newNode.next = tmp;
      current.next = newNode;
    }
  }

  void print() {
    Node temp = root;
    while (temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }

  Node mergeTwoLists(Node n1, Node n2) {
    Node mergedList = null;
    if (n1 == null) {
      return n2 != null ? n2 : null;
    }
    if (n2 == null) {
      return n1 != null ? n1 : null;
    }
    if (n1.val < n2.val) {
      mergedList = n1;
    } else {
      mergedList = n2;
      // to always iterate over same node
      n2 = n1;
      n1 = mergedList;
    }
    while (n1.next != null) {
      if (n1.next.val > n2.val) {
        Node temp = n1.next;
        n1.next = n2;
        n2 = temp;
      }
      n1 = n1.next;
    }
    n1.next = n2;
    return mergedList;
  }

  // n is nth node from the tail
  int getNode(Node head, int n) {
    int val = 0;
    int len = 0;
    Node tmp = head;
    while (tmp != null) {
      len++;
      tmp = tmp.next;
    }

    if (len < n) {
      return val;
    }

    tmp = head;

    for (int i = 0; i < len - n; i++) {
      tmp = tmp.next;
    }
    val = tmp.data;
    return val;
  }

  public static void main(String[] args) {

    LinkedList list = new LinkedList();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    list.print();

    Node n1 = new Node(1);
    n1.next = new Node(4);
    n1.next.next = new Node(5);

    Node n2 = new Node(1);
    n2.next = new Node(2);
    n2.next.next = new Node(3);

    Node merged = list.mergeTwoLists(n1, n2);

    list.add(5, 2);
    list.print();
    list.root = merged;
    list.print();
  }
}