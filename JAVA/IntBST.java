import java.util.Queue;
import java.util.ArrayDeque;

public class IntBST {
  static class Node {
    int data;
    Node left;
    Node right;

    Node() {}

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static int levelWithMaxSum(Node root) {
    int level = 0, maxlevel = 0;
    int currentSum = 0, maxSum = 0;
    Node temp;
    Node end = new Node();
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    queue.add(end);
    while (!queue.isEmpty()) {
      temp = queue.remove();
      if (temp == end) {
        if (currentSum > maxSum) {
          maxSum = currentSum;
          maxlevel = level;
        }

        currentSum = 0;

        if (temp == end) {
          if (!queue.isEmpty()) {
            queue.add(end);
          }
          level++;
        }
      } else {
        currentSum += temp.data;
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
    }
    return maxlevel;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(8);
    root.right.right.left = new Node(6);
    root.right.right.right = new Node(7);

    System.out.println("Level with max sum = " + IntBST.levelWithMaxSum(root));
  }
}