impl Solution {
    pub fn reduction_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        nums.dedup();
        (nums.len() - 1) as i32
    }
}