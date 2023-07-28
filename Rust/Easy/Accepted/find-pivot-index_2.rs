impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
        }
        let mut left = 0;
        for i in 0..nums.len() {
            if left * 2 == sum - nums[i] {
                return i as i32;
            }
            left += nums[i];
        }
        -1
    }
}