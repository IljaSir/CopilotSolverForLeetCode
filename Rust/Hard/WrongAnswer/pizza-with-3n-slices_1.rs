impl Solution {
    pub fn max_size_slices(slices: Vec<i32>) -> i32 {
        
        let n = slices.len() / 3;
        let mut dp = vec![vec![0; n + 1]; n + 1];
        for i in 1..=n {
            for j in 1..=n {
                dp[i][j] = std::cmp::max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = std::cmp::max(dp[i][j], dp[i][j - 1]);
                dp[i][j] = std::cmp::max(dp[i][j], dp[i - 1][j - 1] + slices[i + j - 2]);
            }
        }
        dp[n][n]
    }
}