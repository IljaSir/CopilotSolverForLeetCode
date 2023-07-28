impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        if n < 3 {
            return false;
        }
        let mut min = vec![0; n];
        min[0] = nums[0];
        for i in 1..n {
            min[i] = min[i - 1].min(nums[i]);
        }
        let mut stack = Vec::new();
        for i in (0..n).rev() {
            if nums[i] > min[i] {
                while !stack.is_empty() && stack[stack.len() - 1] <= min[i] {
                    stack.pop();
                }
                if !stack.is_empty() && stack[stack.len() - 1] < nums[i] {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        false
    }
}