impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let m = multipliers.len();
        let mut dp = vec![vec![0; m + 1]; m + 1];
        for i in 0..m {
            dp[i + 1][0] = dp[i][0] + nums[i] * multipliers[i];
            dp[0][i + 1] = dp[0][i] + nums[n - 1 - i] * multipliers[i];
        }
        for i in 0..m {
            for j in 0..m - i {
                dp[i + 1][j + 1] = std::cmp::max(
                    dp[i][j + 1] + nums[i] * multipliers[i + j + 1],
                    dp[i + 1][j] + nums[n - 1 - j] * multipliers[i + j + 1],
                );
            }
        }
        dp[m][m]
    }
}