impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let mut res = vec![-1; nums.len()];
        let mut stack = vec![];
        for i in 0..nums.len() * 2 {
            let num = nums[i % nums.len()];
            while !stack.is_empty() && nums[*stack.last().unwrap()] < num {
                res[*stack.last().unwrap()] = num;
                stack.pop();
            }
            if i < nums.len() {
                stack.push(i);
            }
        }
        res
    }
}