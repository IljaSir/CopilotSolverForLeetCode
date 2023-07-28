/*
Given the root of a binary search tree, and an integer k, return the k^th smallest value (1-indexed) of all the values of the nodes in the tree.

 
Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1


Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


 
Constraints:


	The number of nodes in the tree is n.
	1 <= k <= n <= 10^4
	0 <= Node.val <= 10^4


 
Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
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
    pub fn kth_smallest(root: Option<Rc<RefCell<TreeNode>>>, k: i32) -> i32 {
        
    }
}