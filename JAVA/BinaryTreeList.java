import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;

  TreeNode(int value) {
    this.value = value;
    left = right = null;
  }
}

class BinaryTreeList {

  private List<Integer> values = new ArrayList<>();
  private static TreeNode root;

  BinaryTreeList() { root = null; }

  TreeNode insert(TreeNode root, int data) {
    if (root == null) {
      return new TreeNode(data);
    } else if (data < root.value) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }
    return root;
  }

  void print(TreeNode root) {

    if (root != null) {
      print(root.left);
      values.add(root.value);
      print(root.right);
    }
  }

  /**
   * Convert BinarySearchTree to DoublyLinkedList
   */
  TreeNode treeToDLL(TreeNode root) {
    if (root == null) {
      return null;
    }

    // Get the left and right part of the root to list

    TreeNode aList = treeToDLL(root.left);
    TreeNode bList = treeToDLL(root.right);
    // ____      ____
    //|    |    |    |
    //|     ROOT     |
    //|___ /    \____|
    //
    // this part of the code to root's left and right edges are pointing to it
    // self
    root.left = root;
    root.right = root;

    // append left list, root and right list.
    aList = concat(aList, root);
    aList = concat(bList, aList);
    return aList;
  }

  //    2
  //  /  \
  // 1    3

  private TreeNode concat(TreeNode a, TreeNode b) {
    if (a == null)
      return b;
    if (b == null)
      return a;

    TreeNode aLast = a.left;
    TreeNode bLast = b.left;

    aLast.right = b;
    b.left = aLast;

    bLast.right = a;
    a.left = bLast;

    return a;
  }

  void printList(TreeNode node) {
    TreeNode tmp = node;
    do {
      System.out.println(tmp.value);
      tmp = tmp.left;
    } while (tmp != node);
  }

  public static void main(String[] args) {

    BinaryTreeList btl = new BinaryTreeList();

    root = btl.insert(root, 4);
    root = btl.insert(root, 2);
    root = btl.insert(root, 6);
    root = btl.insert(root, 1);
    root = btl.insert(root, 3);
    root = btl.insert(root, 5);
    root = btl.insert(root, 7);

    btl.print(root);

    btl.values.forEach(x -> System.out.printf(x + "->"));
    System.out.println("End of Tree");

    TreeNode dll = btl.treeToDLL(root);
    btl.printList(dll);
  }
}