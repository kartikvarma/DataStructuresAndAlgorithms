import java.util.ArrayDeque;
import java.util.Queue;

class Node {
  char data;
  Node left;
  Node right;

  public Node(char data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public Node() {}
}

class PLenght {
  int len;
}

public class BST {

  static int preOrderIdx = 0;

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

  Node buildTreePreIn(char in[], char pre[], int start, int end) {
    if (start > end) {
      return null;
    }
    Node root = new Node(pre[preOrderIdx++]);

    if (start == end) {
      return root;
    }
    int inOrderRootIndex = search(in, root.data, start, end);

    root.left = buildTreePreIn(in, pre, start, inOrderRootIndex - 1);
    root.right = buildTreePreIn(in, pre, inOrderRootIndex + 1, end);

    return root;
  }

  /**
   * Build tree when a post order and in order is given
   */
  Node buildTreePostIn(char in[], char post[], int start, int end, PLenght pl) {
    if (start > end) {
      return null;
    }

    // last node of the post is the root
    Node root = new Node(post[pl.len]);

    if (start == end) {
      return root;
    }

    pl.len--;

    int index = search(in, root.data, start, end);

    root.right = buildTreePostIn(in, post, index + 1, end, pl);
    root.left = buildTreePostIn(in, post, start, index - 1, pl);

    return root;
  }

  int search(char inOrder[], char val, int start, int end) {
    int idx = 0;
    for (int i = start; i <= end; i++) {
      if (inOrder[i] == val) {
        idx = i;
        break;
      }
    }
    return idx;
  }

  public static void main(String[] args) {

    char inOrder[] = {'D', 'B', 'E', 'A', 'F', 'C'};
    char preOrder[] = {'A', 'B', 'D', 'E', 'C', 'F'};
    char postOrder[] = {'D', 'E', 'B', 'F', 'C', 'A'};
    BST bst = new BST();
    Node inPreRoot =
        bst.buildTreePreIn(inOrder, preOrder, 0, inOrder.length - 1);
    PLenght pl = new PLenght();
    pl.len = postOrder.length - 1;
    Node inPostRoot =
        bst.buildTreePostIn(inOrder, postOrder, 0, inOrder.length - 1, pl);
    bst.printTree(inPreRoot);
    System.out.println("\n *************** \n");
    bst.printTree(inPostRoot);
  }
}