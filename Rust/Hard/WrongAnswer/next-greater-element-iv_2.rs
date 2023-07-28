impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut stack = Vec::new();
        let mut res = vec![-1; nums.len()];
        for i in 0..nums.len() {
            while let Some(&top) = stack.last() {
                if nums[top] < nums[i] {
                    res[top] = nums[i];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        res
    }
}