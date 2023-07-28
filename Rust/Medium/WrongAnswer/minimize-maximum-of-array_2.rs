impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
        }
        let mut min = nums[0];
        for i in 1..nums.len() {
            if nums[i] < min {
                min = nums[i];
            }
        }
        sum - min * (nums.len() as i32)
    }
}