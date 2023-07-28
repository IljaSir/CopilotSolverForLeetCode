impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let m = multipliers.len();
        let mut dp = vec![vec![0; m + 1]; m + 1];
        for i in 1..=m {
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * multipliers[i - 1];
            dp[0][i] = dp[0][i - 1] + nums[n - i] * multipliers[i - 1];
        }
        for i in 1..=m {
            for j in 1..=m - i {
                dp[i][j] = std::cmp::max(
                    dp[i - 1][j] + nums[i - 1] * multipliers[i + j - 1],
                    dp[i][j - 1] + nums[n - j] * multipliers[i + j - 1],
                );
            }
        }
        dp[m][0]
    }
}