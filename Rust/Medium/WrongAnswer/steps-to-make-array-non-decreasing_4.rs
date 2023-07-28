impl Solution {
    pub fn total_steps(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut steps = 0;
        for i in 1..nums.len() {
            if nums[i-1] > nums[i] {
                steps += 1;
                nums[i] = nums[i-1];
            }
        }
        steps
    }
}