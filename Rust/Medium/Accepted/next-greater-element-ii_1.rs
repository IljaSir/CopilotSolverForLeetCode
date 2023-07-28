impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let mut stack = Vec::new();
        let mut res = vec![-1; nums.len()];
        for i in 0..nums.len() * 2 {
            while let Some(&top) = stack.last() {
                if nums[top] < nums[i % nums.len()] {
                    res[top] = nums[i % nums.len()];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i % nums.len());
        }
        res
    }
}