impl Solution {
    pub fn total_steps(nums: Vec<i32>) -> i32 {
        
        let mut steps = 0;
        for i in 1..nums.len() {
            if nums[i] < nums[i - 1] {
                steps += nums[i - 1] - nums[i];
                nums[i] = nums[i - 1];
            }
        }
        steps
    }
}