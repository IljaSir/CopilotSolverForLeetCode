impl Solution {
    pub fn find_middle_index(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
        }
        let mut left_sum = 0;
        for i in 0..nums.len() {
            if left_sum == sum - left_sum - nums[i] {
                return i as i32;
            }
            left_sum += nums[i];
        }
        -1
    }
}