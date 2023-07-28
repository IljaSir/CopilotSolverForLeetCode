impl Solution {
    pub fn total_steps(nums: Vec<i32>) -> i32 {
        
        let mut steps = 0;
        let mut prev = nums[0];
        for i in 1..nums.len() {
            if nums[i] < prev {
                steps += 1;
            } else {
                prev = nums[i];
            }
        }
        steps
    }
}