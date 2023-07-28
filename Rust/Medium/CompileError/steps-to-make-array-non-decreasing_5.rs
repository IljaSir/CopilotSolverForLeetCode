impl Solution {
    pub fn total_steps(nums: Vec<i32>) -> i32 {
        
        let mut steps = 0;
        let mut i = 1;
        while i < nums.len() {
            if nums[i] < nums[i - 1] {
                steps += 1;
                if i > 1 && nums[i] < nums[i - 2] {
                    nums[i] = nums[i - 1];
                }
            }
            i += 1;
        }
        steps
    }
}