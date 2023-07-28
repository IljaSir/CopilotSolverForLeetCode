impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut stack = vec![];
        let mut res = vec![-1; nums.len()];
        for (i, x) in nums.iter().enumerate() {
            while let Some(&top) = stack.last() {
                if nums[top] < *x {
                    res[top] = *x;
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