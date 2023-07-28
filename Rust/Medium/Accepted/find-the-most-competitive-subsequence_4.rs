impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack = Vec::new();
        let mut k = k as usize;
        for i in 0..nums.len() {
            while stack.len() > 0 && nums[i] < *stack.last().unwrap() && stack.len() + nums.len() - i > k {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(nums[i]);
            }
        }
        stack
    }
}