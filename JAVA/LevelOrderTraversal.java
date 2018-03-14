import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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
    System.out.println("Printing in natural order\n");
    bst.print(false);
    System.out.println("\n\n");
    System.out.println("Printing in reverse order\n");
    bst.print(true);
    System.out.println("\n\n");

    System.out.println("Minimum value in Tree : " + bst.findMin());
    System.out.println("Maximum value in Tree : " + bst.findMax());
    System.out.println("Find value 10 in Tree : " + bst.search(10));
    System.out.println("Find value 7 in Tree : " + bst.search(7));
    System.out.println("Size of Tree is : " + bst.size());
    System.out.println("Height of Tree is : " + bst.height());
  }
}

class Node<T> {
  T data;
  Node<T> left = null;
  Node<T> right = null;

  public Node() {}

  public Node(T data, Node<T> left, Node<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

class BinarySearchTree<T extends Comparable<T>> {

  private Node<T> root;

  public BinarySearchTree() { this.root = null; }

  /**
   * Insert an element into tree
   * when value greater then root add to the right sub tree
   * when value lesser then root add to the left sub tree
   * @param value - value of the expected type.
   */
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

  /**
   *  print all the values in a tree
   *  @param reverse - when true will print the values in reverse order
   */
  public void print(boolean reverse) {
    Queue<Node<T>> queue = new ArrayDeque<>();
    Stack<T> stack = new Stack<>();
    Node<T> temp = null;
    queue.add(root);
    while (!queue.isEmpty()) {
      temp = queue.remove();
      if (!reverse) {
        System.out.println(temp.data);
      } else {
        stack.add(temp.data);
      }

      if (temp.left != null) {
        queue.add(temp.left);
      }

      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  /**
   * Find minimum value in a Tree
   */
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

  /**
   * Find the maximum value in a Tree
   */
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

  /**
   * search for an element in Tree
   */
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

  /**
   * Size of binary tree
   */
  public int size() {
    int count = 0;
    Queue<Node<T>> queue = new ArrayDeque<>();
    Node<T> temp = null;
    queue.add(root);
    while (!queue.isEmpty()) {
      temp = queue.remove();

      count++;

      if (temp.left != null) {
        queue.add(temp.left);
      }

      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    return count;
  }

  /**
   * Height of the binary tree
   * BFS - Breadth first search in the graphs
   *
   */
  public int height() {
    int count = 0;
    Queue<Node<T>> queue = new ArrayDeque<>();
    Node<T> temp = null;
    Node<T> end = new Node<>();
    queue.add(root);
    queue.add(end);
    while (!queue.isEmpty()) {
      temp = queue.remove();

      if (temp == end) {
        if (!queue.isEmpty()) {
          queue.add(end);
        }
        count++;
      }

      if (temp.left != null) {
        queue.add(temp.left);
      }

      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    return count;
  }
}