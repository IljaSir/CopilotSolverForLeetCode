impl Solution {
    pub fn total_steps(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut steps = 0;
        let mut i = 1;
        while i < nums.len() {
            if nums[i-1] > nums[i] {
                steps += 1;
                if i > 1 && nums[i-2] > nums[i] {
                    nums[i] = nums[i-1];
                } else {
                    nums[i-1] = nums[i];
                }
            } else {
                i += 1;
            }
        }
        steps
    }
}