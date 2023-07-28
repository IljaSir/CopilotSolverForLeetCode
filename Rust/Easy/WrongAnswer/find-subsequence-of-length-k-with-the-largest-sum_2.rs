impl Solution {
    pub fn max_subsequence(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack = Vec::new();
        let mut k = k as usize;
        for i in 0..nums.len() {
            while !stack.is_empty() && nums.len() - i + stack.len() > k && nums[i] > *stack.last().unwrap() {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(nums[i]);
            }
        }
        stack
    }
}