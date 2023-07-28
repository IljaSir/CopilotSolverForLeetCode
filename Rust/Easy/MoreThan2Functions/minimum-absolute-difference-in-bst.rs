/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 
Example 1:


Input: root = [4,2,6,1,3]
Output: 1


Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1


 
Constraints:


	The number of nodes in the tree is in the range [2, 10^4].
	0 <= Node.val <= 10^5


 
Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
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
    pub fn get_minimum_difference(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        
    }
}