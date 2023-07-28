impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let mut stack = Vec::new();
        let mut res = vec![-1; nums.len()];
        for i in (0..nums.len()).rev() {
            while !stack.is_empty() && stack[stack.len() - 1] <= nums[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                res[i] = stack[stack.len() - 1];
            }
            stack.push(nums[i]);
        }
        for i in (0..nums.len()).rev() {
            while !stack.is_empty() && stack[stack.len() - 1] <= nums[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                res[i] = stack[stack.len() - 1];
            }
            stack.push(nums[i]);
        }
        res
    }
}