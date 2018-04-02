#ifndef BINARY_TREE_H
#define BINARY_TREE_H

#include <iostream>

using namespace std;

namespace kbalgo {
template <class T> // T is the datatype
class BinarySearchTree {
private:
  struct TreeNode {
    T data;
    TreeNode *right;
    TreeNode *left;
  }; // end of Struct TreeNode

public:
  BinarySearchTree();
  ~BinarySearchTree();

  void insert(const T &arg);

  void remove(const T &arg);

  bool search(const T &arg);

  void printTree() const;

private:
  TreeNode *root;
  TreeNode *getNode();
  void _insert(TreeNode *root);

}; // class end

}; // namespace kbalgo

#endif // !BINARY_TREE_H
