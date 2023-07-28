impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut k = k as usize;
        let mut nums = nums;
        let mut stack = vec![];
        for i in 0..nums.len() {
            while !stack.is_empty() && nums[i] < stack[stack.len()-1] && stack.len() - 1 + nums.len() - i >= k {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(nums[i]);
            }
        }
        stack
    }
}