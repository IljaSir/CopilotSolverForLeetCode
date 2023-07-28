impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let mut stack = Vec::new();
        let mut min = std::i32::MAX;
        for i in (0..nums.len()).rev() {
            if nums[i] < min {
                min = nums[i];
            } else if nums[i] > min {
                while let Some(&top) = stack.last() {
                    if top < nums[i] {
                        return true;
                    }
                    stack.pop();
                }
                stack.push(min);
                stack.push(nums[i]);
            }
        }
        false
    }
}