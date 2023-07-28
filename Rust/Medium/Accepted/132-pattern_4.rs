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

        let mut stack = vec![];
        for j in (0..n).rev() {
            if nums[j] > min[j] {
                while !stack.is_empty() && stack[stack.len() - 1] <= min[j] {
                    stack.pop();
                }
                if !stack.is_empty() && stack[stack.len() - 1] < nums[j] {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        false
    }
}