impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut stack = Vec::new();
        let mut result = vec![-1; nums.len()];
        for i in 0..nums.len() {
            while let Some(&j) = stack.last() {
                if nums[j] < nums[i] {
                    result[j] = nums[i];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        result
    }
}