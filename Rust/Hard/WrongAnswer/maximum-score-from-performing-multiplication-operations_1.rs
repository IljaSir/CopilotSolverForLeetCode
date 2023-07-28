impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let m = multipliers.len();
        let mut dp = vec![vec![0; m + 1]; m + 1];
        for i in 0..m {
            dp[i][0] = dp[i][0] + multipliers[i] * nums[i];
            dp[i + 1][0] = dp[i][0] + multipliers[i] * nums[n - i - 1];
        }
        for j in 1..m {
            for i in 0..m - j {
                dp[i][j] = std::cmp::max(
                    dp[i][j],
                    dp[i][j - 1] + multipliers[i + j] * nums[i],
                );
                dp[i][j] = std::cmp::max(
                    dp[i][j],
                    dp[i + 1][j - 1] + multipliers[i + j] * nums[n - j - 1 - i],
                );
            }
        }
        return *dp[0].iter().max().unwrap();
    }
}