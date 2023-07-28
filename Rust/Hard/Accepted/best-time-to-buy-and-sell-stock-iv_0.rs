impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let n = prices.len();
        if n < 2 {
            return 0;
        }
        let k = k as usize;
        let mut dp = vec![vec![vec![0; 2]; k + 1]; n];
        for j in 0..=k {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }
        for i in 1..n {
            for j in 0..=k {
                if j == 0 {
                    dp[i][j][0] = dp[i - 1][j][0];
                    dp[i][j][1] = std::cmp::max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                } else {
                    dp[i][j][0] = std::cmp::max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                    dp[i][j][1] = std::cmp::max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                }
            }
        }
        dp[n - 1][k][0]
    }
}