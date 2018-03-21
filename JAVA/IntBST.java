import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

  public static void printPaths(Node root, int nodes[], int pathLength) {
    if (root == null) {
      return;
    }

    nodes[pathLength] = root.data;
    pathLength++;

    if (root.left == null && root.right == null) {
      print(nodes, pathLength);
    } else {
      printPaths(root.left, nodes, pathLength);
      printPaths(root.right, nodes, pathLength);
    }
  }

  public static Node mirrorBST(Node root) {
    Node temp;
    if (root != null) {
      mirrorBST(root.left);
      mirrorBST(root.right);
      temp = root.left;
      root.left = root.right;
      root.right = temp;
    }
    return root;
  }

  private static void print(int nodes[], int length) {
    System.out.println("Start\n");
    int sum = 0;
    for (int i = 0; i < length; i++) {
      System.out.println(nodes[i]);
      sum += nodes[i];
    }
    System.out.println("\n Sum in the path : " + sum);
    System.out.println("\nDone\n");
  }

  public static boolean hasPathSum(Node root, int sum) {

    if (root == null) {
      return sum == 0 ? true : false;
    } else {
      int remaining = sum - root.data;
      return (hasPathSum(root.left, remaining) ||
              hasPathSum(root.right, remaining));
    }
  }

  public static void printTree(Node root) {
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

  public static Node leastCommonAncestor(Node root, int n1, int n2) {
    if (root == null) {
      return null;
    }
    if (root.data > n1 && root.data > n2) {
      return leastCommonAncestor(root.left, n1, n2);
    }
    if (root.data < n1 && root.data < n2) {
      return leastCommonAncestor(root.right, n1, n2);
    }
    return root;
  }

  public static Node iterativeLCA(Node root, int n1, int n2) {
    if (root == null) {
      return null;
    }
    while (root != null) {
      if (root.data > n1 && root.data > n2) {
        root = root.left;
      } else if (root.data < n1 && root.data < n2) {
        root = root.right;
      } else {
        break;
      }
    }
    return root;
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
    IntBST.printPaths(root, new int[100], 0);
    System.out.println("Tree has sum equal 18 : " +
                       IntBST.hasPathSum(root, 18));

    IntBST.printTree(root);
    Node mirror = IntBST.mirrorBST(root);
    IntBST.printTree(mirror);

    Node lca = IntBST.leastCommonAncestor(root, 2, 6);
    Node iLca = IntBST.iterativeLCA(root, 6, 7);
    System.out.println("LCA for 2 and 6 is : " +
                       (lca != null ? lca.data : lca));
    System.out.println("LCA for 6 and 7 is : " +
                       (iLca != null ? iLca.data : iLca));
  }
}