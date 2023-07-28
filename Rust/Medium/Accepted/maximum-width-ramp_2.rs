impl Solution {
    pub fn max_width_ramp(nums: Vec<i32>) -> i32 {
        
        let mut stack = vec![];
        let mut max_width = 0;
        for i in 0..nums.len() {
            if stack.is_empty() || nums[i] < nums[*stack.last().unwrap()] {
                stack.push(i);
            }
        }
        for i in (0..nums.len()).rev() {
            while !stack.is_empty() && nums[i] >= nums[*stack.last().unwrap()] {
                max_width = max_width.max(i - stack.pop().unwrap());
            }
        }
        max_width as i32
    }
}