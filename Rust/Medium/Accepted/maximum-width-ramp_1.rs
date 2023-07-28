impl Solution {
    pub fn max_width_ramp(nums: Vec<i32>) -> i32 {
        
        let mut stack = vec![];
        for (i, &num) in nums.iter().enumerate() {
            if stack.is_empty() || num < nums[stack[stack.len() - 1]] {
                stack.push(i);
            }
        }
        let mut ans = 0;
        for (i, &num) in nums.iter().enumerate().rev() {
            while !stack.is_empty() && num >= nums[stack[stack.len() - 1]] {
                ans = ans.max(i - stack.pop().unwrap());
            }
        }
        ans as i32
    }
}