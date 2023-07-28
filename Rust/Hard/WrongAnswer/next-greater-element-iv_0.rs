impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![-1; nums.len()];
        let mut stack = vec![];
        for i in (0..nums.len()).rev() {
            while !stack.is_empty() && nums[stack[stack.len() - 1]] <= nums[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                res[i] = nums[stack[stack.len() - 1]];
            }
            stack.push(i);
        }
        res
    }
}