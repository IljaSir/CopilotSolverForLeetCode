/*
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 
Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]


Example 2:


Input: root = [1,2,3]
Output: [1,3]


 
Constraints:


	The number of nodes in the tree will be in the range [0, 10^4].
	-2^31 <= Node.val <= 2^31 - 1

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
    pub fn largest_values(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        
    }
}