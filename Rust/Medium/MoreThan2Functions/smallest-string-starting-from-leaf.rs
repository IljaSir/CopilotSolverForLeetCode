/*
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.


	For example, "ab" is lexicographically smaller than "aba".


A leaf of a node is a node that has no children.

 
Example 1:


Input: root = [0,1,2,3,4,3,4]
Output: "dba"


Example 2:


Input: root = [25,1,3,1,3,0,2]
Output: "adz"


Example 3:


Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"


 
Constraints:


	The number of nodes in the tree is in the range [1, 8500].
	0 <= Node.val <= 25

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
    pub fn smallest_from_leaf(root: Option<Rc<RefCell<TreeNode>>>) -> String {
        
    }
}