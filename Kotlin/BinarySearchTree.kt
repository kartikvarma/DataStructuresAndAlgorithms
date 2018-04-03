class TreeNode (data: Int){
  var data:Int = data
  var left:TreeNode? = null
  var right:TreeNode? = null
}

class BinaryTree {

  var root:TreeNode? = null

  fun insert(data: Int){
    root = insert(root, data)
  }

  private fun insert(root:TreeNode?, data:Int) :TreeNode {
    if(root == null){
      return TreeNode(data)
    }
    else if(data > root.data){
     root.right = insert(root.right, data)
    }
    else {
     root.left = insert(root.left, data)
    }
    return root
  }
}

fun main(args: Array<String>) {
  var tree = BinaryTree()
  tree.insert(4);
  tree.insert(2);
  tree.insert(8);
  tree.insert(5);
  tree.insert(1);
  tree.insert(7);
  tree.insert(6);

}