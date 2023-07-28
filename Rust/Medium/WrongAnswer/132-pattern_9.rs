impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let mut stack = Vec::new();
        let mut min = std::i32::MAX;
        for i in (0..nums.len()).rev() {
            let n = nums[i];
            if n < min {
                min = n;
            } else if n > min {
                while !stack.is_empty() && stack[stack.len()-1] <= min {
                    stack.pop();
                }
                if !stack.is_empty() && stack[stack.len()-1] < n {
                    return true;
                }
                stack.push(n);
            }
        }
        false
    }
}