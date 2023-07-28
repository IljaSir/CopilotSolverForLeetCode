impl Solution {
    pub fn max_width_ramp(nums: Vec<i32>) -> i32 {
        
        let mut stack = Vec::new();
        for i in 0..nums.len() {
            if stack.is_empty() || nums[stack[stack.len()-1]] > nums[i] {
                stack.push(i);
            }
        }
        let mut res = 0;
        for i in (0..nums.len()).rev() {
            while !stack.is_empty() && nums[stack[stack.len()-1]] <= nums[i] {
                if i - stack[stack.len()-1] > res {
                    res = i - stack[stack.len()-1];
                }
                stack.pop();
            }
        }
        res as i32
    }
}