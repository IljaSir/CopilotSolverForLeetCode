impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::new();
        let mut res: Vec<i32> = vec![-1; nums.len()];
        for i in 0..nums.len() {
            while let Some(&last) = stack.last() {
                if nums[last as usize] < nums[i] {
                    res[last as usize] = nums[i];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i as i32);
        }
        res
    }
}