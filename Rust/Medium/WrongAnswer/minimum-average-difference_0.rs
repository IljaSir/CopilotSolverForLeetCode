impl Solution {
    pub fn minimum_average_difference(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        let mut min = std::i32::MAX;
        for i in 0..n {
            sum += nums[i];
            if i >= 4 {
                sum -= nums[i - 4];
            }
            if i >= 3 {
                min = min.min((sum - nums[i - 3] * 3).abs());
            }
        }
        min
    }
}