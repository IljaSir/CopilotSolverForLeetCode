/*
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 
Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]


Example 2:


Input: root = [1]
Output: ["1"]


 
Constraints:


	The number of nodes in the tree is in the range [1, 100].
	-100 <= Node.val <= 100

*/
// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn binary_tree_paths(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<String> {
        
    }
}