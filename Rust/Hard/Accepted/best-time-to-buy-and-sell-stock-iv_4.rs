impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let n = prices.len();
        if n <= 1 {
            return 0;
        }
        let mut dp = vec![vec![vec![0; 2]; n]; k as usize + 1];
        for i in 0..n {
            dp[0][i][0] = 0;
            dp[0][i][1] = std::i32::MIN;
        }
        for i in 0..k as usize + 1 {
            dp[i][0][0] = 0;
            dp[i][0][1] = -prices[0];
        }
        for i in 1..k as usize + 1 {
            for j in 1..n {
                dp[i][j][0] = std::cmp::max(dp[i][j - 1][0], dp[i][j - 1][1] + prices[j]);
                dp[i][j][1] = std::cmp::max(dp[i][j - 1][1], dp[i - 1][j - 1][0] - prices[j]);
            }
        }
        dp[k as usize][n - 1][0]
    }
}