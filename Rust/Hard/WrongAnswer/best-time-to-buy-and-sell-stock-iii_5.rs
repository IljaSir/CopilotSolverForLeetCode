impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 3]; prices.len()];
        for i in 1..prices.len() {
            let diff = prices[i] - prices[i - 1];
            for k in 1..=2 {
                dp[i][k] = std::cmp::max(dp[i - 1][k], dp[i - 1][k - 1] + diff);
                dp[i][k] = std::cmp::max(dp[i][k], dp[i - 1][k - 1]);
                dp[i][k] = std::cmp::max(dp[i][k], dp[i][k - 1]);
            }
        }
        dp[prices.len() - 1][2]
    }
}