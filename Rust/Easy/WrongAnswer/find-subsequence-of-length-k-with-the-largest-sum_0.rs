impl Solution {
    pub fn max_subsequence(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack = Vec::new();
        let mut k = k as usize;
        for i in 0..nums.len() {
            while !stack.is_empty() && stack.len() + nums.len() - i > k && stack[stack.len()-1] < nums[i] {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        while stack.len() > k {
            stack.pop();
        }
        stack
    }
}