class TreeNode {
  int val;
  TreeNode child;
  TreeNode sibiling;

  public TreeNode(int val) {
    this.val = val;
  }
}

public class NAryTree {

  int sumOfNodes(TreeNode root) {
    if (root == null)
      return 0;
    return root.val + sumOfNodes(root.child) + sumOfNodes(root.sibiling);
  }

  int sibilingCount(TreeNode root) {
    if (root == null)
      return 0;
    int count = 0;
    root = root.sibiling;
    while (root != null) {
      count++;
      root = root.sibiling;
    }
    return count;
  }

  int childCount(TreeNode root) {
    if (root == null)
      return 0;
    int count = 0;
    root = root.child;
    while (root != null) {
      count++;
      root = root.child;
    }
    return count;
  }

  public static void main(String[] args) {
    NAryTree tree = new NAryTree();
    TreeNode root = new TreeNode(1);
    root.child = new TreeNode(2);
    root.child.child = new TreeNode(5);
    root.sibiling = new TreeNode(3);
    root.sibiling.sibiling = new TreeNode(4);

    System.out.println(tree.sumOfNodes(root));
    System.out.println(tree.childCount(root));
    System.out.println(tree.sibilingCount(root));
  }

}