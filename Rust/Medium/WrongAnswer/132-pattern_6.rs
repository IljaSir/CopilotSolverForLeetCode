impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let mut stack: Vec<i32> = vec![];
        let mut min = std::i32::MAX;
        for i in (0..nums.len()).rev() {
            if nums[i] < min {
                min = nums[i];
            } else if nums[i] > min {
                while stack.len() > 0 && stack[stack.len() - 1] <= min {
                    stack.pop();
                }
                if stack.len() > 0 && stack[stack.len() - 1] < nums[i] {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        false
    }
}