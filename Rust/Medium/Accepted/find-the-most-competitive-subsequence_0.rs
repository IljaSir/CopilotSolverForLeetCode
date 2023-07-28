impl Solution {
    pub fn most_competitive(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut stack = vec![];
        let n = nums.len();
        let k = k as usize;
        for i in 0..n {
            while !stack.is_empty() && nums[i] < stack[stack.len() - 1] && stack.len() + n - i > k {
                stack.pop();
            }
            if stack.len() < k {
                stack.push(nums[i]);
            }
        }
        stack
    }
}