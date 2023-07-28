impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        
        let mut dp = (0, 0);
        for num in nums {
            dp = (dp.1 + num as i64, dp.0.max(dp.1));
        }
        dp.0.max(dp.1)
    }
}