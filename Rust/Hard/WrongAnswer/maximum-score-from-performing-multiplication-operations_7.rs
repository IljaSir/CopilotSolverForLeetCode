impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; multipliers.len()]; multipliers.len()];
        for i in 0..multipliers.len() {
            for j in 0..multipliers.len() {
                if i == 0 && j == 0 {
                    dp[i][j] = nums[0] * multipliers[0];
                } else if i == 0 {
                    dp[i][j] = dp[i][j-1] + nums[nums.len() - j] * multipliers[j];
                } else if j == 0 {
                    dp[i][j] = dp[i-1][j] + nums[i] * multipliers[i];
                } else {
                    dp[i][j] = std::cmp::max(dp[i-1][j] + nums[i] * multipliers[i], dp[i][j-1] + nums[nums.len() - j] * multipliers[j]);
                }
            }
        }
        dp[multipliers.len() - 1][multipliers.len() - 1]
    }
}