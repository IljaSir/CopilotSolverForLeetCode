impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let n = nums.len();
        let mut sum = 0;
        let mut min = i32::MAX;
        for i in 0..n {
            sum += nums[i];
            min = min.min(nums[i]);
        }
        sum - n as i32 * min
    }
}