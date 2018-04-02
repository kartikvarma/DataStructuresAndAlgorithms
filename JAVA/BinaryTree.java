class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
    left = right = null;
  }
}

public class BinaryTree {

  /**
   *  4                                 6
   *    \                             /   \
   *      6   -> "left rotate" ->    4     8
   *        \
   *          8
   */
  public TreeNode leftRotate(TreeNode root) {
    TreeNode tmp = root.right;
    root.right = tmp.left;
    tmp.left = root;
    return tmp;
  }

  /**
   *        8                             6
   *       /                            /   \
   *      6   -> "right rotate" ->     4     8
   *     /
   *    4
   */

  public TreeNode rightRotate(TreeNode root) {
    TreeNode tmp = root.left;
    root.left = tmp.right;
    tmp.right = root;
    return tmp;
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    TreeNode rightTree = new TreeNode(4);
    rightTree.right = new TreeNode(6);
    rightTree.right.right = new TreeNode(8);

    rightTree = tree.leftRotate(rightTree);

    TreeNode leftTree = new TreeNode(8);
    leftTree.left = new TreeNode(6);
    leftTree.left.left = new TreeNode(4);

    leftTree = tree.rightRotate(leftTree);
  }
}