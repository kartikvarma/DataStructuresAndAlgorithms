
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Node {
  String data;
  Node left;
  Node right;

  Node(String data) { this.data = data; }

  Node() {}
}

public class MoreBST {

  Node head;

  int index = 0;

  void zigzagTraversal() {
    Node temp = null;
    boolean leftToRight = false;
    Stack<Node> current = new Stack<>();
    Stack<Node> next = new Stack<>();

    current.push(head);

    while (!current.empty()) {
      temp = current.pop();

      if (temp != null) {
        System.out.println(temp.data);
        if (leftToRight) {
          if (temp.left != null) {
            next.push(temp.left);
          }
          if (temp.right != null) {
            next.push(temp.right);
          }
        } else {
          if (temp.right != null) {
            next.push(temp.right);
          }
          if (temp.left != null) {
            next.push(temp.left);
          }
        }
      }

      if (current.empty()) {
        leftToRight = true;
        current = next;
      }
    }
  }

  /**
   * given a preorder traversal of a tree - ILILL where L is node and I is
   * internal Node Build a Tree;
   */
  Node buildTree(String pre[]) {
    Node root = new Node(pre[index++]);

    if (root.data == "L") {
      return root;
    }

    root.left = buildTree(pre);
    root.right = buildTree(pre);

    return root;
  }

  void printTree(Node root) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    Node temp;
    while (!queue.isEmpty()) {
      temp = queue.remove();
      System.out.println(temp.data);

      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
  }

  public static void main(String[] args) {
    MoreBST m = new MoreBST();
    m.head = new Node("A");
    m.head.left = new Node("B");
    m.head.right = new Node("C");
    m.head.left.left = new Node("D");
    m.head.left.right = new Node("E");
    m.head.right.right = new Node("F");
    m.head.right.left = new Node("G");
    m.head.right.right.left = new Node("H");
    m.head.right.right.right = new Node("I");

    m.zigzagTraversal();

    String preOrder[] = {"I", "L", "I", "L", "L"};

    Node root = m.buildTree(preOrder);
    m.printTree(root);
  }
}