impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        
        let mut dp = vec![0; nums.len()];
        dp[0] = nums[0];
        let mut ans = dp[0];
        for i in 1..nums.len() {
            dp[i] = nums[i];
            if i > 1 {
                dp[i] = std::cmp::max(dp[i], dp[i-2] + nums[i]);
            }
            ans = std::cmp::max(ans, dp[i]);
        }
        ans as i64
    }
}