impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut stack = vec![];
        let mut res = vec![-1; nums.len()];
        for i in (0..nums.len()).rev() {
            while stack.len() > 0 && nums[i] > nums[stack[stack.len() - 1]] {
                stack.pop();
            }
            if stack.len() > 0 {
                res[i] = nums[stack[stack.len() - 1]];
            }
            stack.push(i);
        }
        res
    }
}