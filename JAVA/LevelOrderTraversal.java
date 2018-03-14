import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LevelOrderTraversal {

  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(6);
    bst.insert(4);
    bst.insert(8);
    bst.insert(3);
    bst.insert(5);
    bst.insert(7);
    bst.insert(9);

    bst.print();

    System.out.println("Minimum value in Tree : " + bst.findMin());
    System.out.println("Maximum value in Tree : " + bst.findMax());
    System.out.println("Find value 10 in Tree : " + bst.search(10));
    System.out.println("Find value 7 in Tree : " + bst.search(7));
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

  public BinarySearchTree() { this.root = null; }

  public void insert(T value) { root = insert(root, value); }

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

  public void print() {
    Queue<Node<T>> queue = new ArrayDeque<>();
    Node<T> temp = null;
    queue.add(root);
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

  public T findMin() {
    T min = null;
    Queue<Node<T>> queue = new ArrayDeque<>();
    Node<T> temp = null;
    queue.add(root);
    while (!queue.isEmpty()) {
      temp = queue.remove();

      if (min == null || min.compareTo(temp.data) > 0) {
        min = temp.data;
      }

      if (temp.left != null) {
        queue.add(temp.left);
      }

      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    return min;
  }

  public T findMax() {
    T max = null;
    Queue<Node<T>> queue = new ArrayDeque<>();
    Node<T> temp = null;
    queue.add(root);
    while (!queue.isEmpty()) {
      temp = queue.remove();

      if (max == null || max.compareTo(temp.data) < 0) {
        max = temp.data;
      }

      if (temp.left != null) {
        queue.add(temp.left);
      }

      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    return max;
  }

  public boolean search(T value) {
    Queue<Node<T>> queue = new ArrayDeque<>();
    Node<T> temp = null;
    queue.add(root);
    while (!queue.isEmpty()) {
      temp = queue.remove();

      if (value.compareTo(temp.data) == 0) {
        return true;
      }

      if (temp.left != null) {
        queue.add(temp.left);
      }

      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    return false;
  }
}