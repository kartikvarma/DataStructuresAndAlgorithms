import java.lang.*;
import java.util.Stack;

public class BSTPreOrderTraversal {

  public static void main(String[] args) {

    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(6);
    bst.insert(4);
    bst.insert(8);
    bst.insert(3);
    bst.insert(5);
    bst.insert(7);
    bst.insert(9);

    bst.printRecursive();
    bst.printNonRecursive();
  }
}

class Node<T> {
  T data;
  Node<T> left = null;
  Node<T> right = null;

  Node(T data, Node<T> left, Node<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

class BinarySearchTree<T extends Comparable<T>> {

  private Node<T> root;

  public BinarySearchTree() {
    this.root = null;
  }

  public void insert(T value) {
    root = insert(root, value);
  }

  private Node<T> insert(Node<T> root, T value) {
    if (root == null) {
      return new Node<>(value, null, null);
    } else if (value.compareTo(root.data) > 0) {
      root.right = insert(root.right, value);
    } else if (value.compareTo(root.data) < 0) {
      root.left = insert(root.left, value);
    }
    return root;
  }

  public void printRecursive() {
    if (this.root != null) {
      recursivePreOrderTraversal(this.root);
    }
  }

  public void printNonRecursive() {
    Stack<Node<T>> stack = new Stack<>();

    while (true) {
      while (root != null) {
        System.out.println(root.data);
        stack.push(root);
        root = root.left;
      }

      if (stack.isEmpty()) {
        break;
      }

      root = stack.pop();
      root = root.right;

    }
  }

  private void recursivePreOrderTraversal(Node<T> root) {
    if (root != null) {
      System.out.println(root.data);
      recursivePreOrderTraversal(root.left);
      recursivePreOrderTraversal(root.right);

    }
  }
}