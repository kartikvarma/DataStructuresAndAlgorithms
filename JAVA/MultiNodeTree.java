class TreeNode {
  int data;
  TreeNode child;
  TreeNode sibling;

  TreeNode(int data) { this.data = data; }

  TreeNode() {}
}

public class MultiNodeTree {

  int sumOfNodes(TreeNode root) {
    if (root != null) {
      return root.data + sumOfNodes(root.child) + sumOfNodes(root.sibling);
    } else {
      return 0;
    }
  }

  /*  int sumOfNodeIterative(TreeNode root) {
     if (root == null) {
       return 0;
     }
     else {

     }
   } */

  int height(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + Math.max(height(root.child), height(root.sibling));
    }
  }

  public static void main(String[] args) {
    MultiNodeTree mnt = new MultiNodeTree();
    TreeNode root = new TreeNode(1);
    root.child = new TreeNode(2);
    root.child.sibling = new TreeNode(3);
    root.child.sibling.child = new TreeNode(5);
    root.child.sibling.child.sibling = new TreeNode(6);
    root.child.sibling.sibling = new TreeNode(4);

    System.out.println(mnt.sumOfNodes(root));
  }
}