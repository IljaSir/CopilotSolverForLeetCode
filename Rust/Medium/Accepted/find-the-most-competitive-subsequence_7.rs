impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut k = k as usize;
        let mut stack = Vec::new();
        let mut n = nums.len();
        for i in 0..n {
            while !stack.is_empty() && nums[i] < *stack.last().unwrap() && n - i - 1 >= k - stack.len() {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(nums[i]);
            }
        }
        stack
    }
}