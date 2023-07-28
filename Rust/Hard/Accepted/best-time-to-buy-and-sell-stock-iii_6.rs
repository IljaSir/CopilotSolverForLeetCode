impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![vec![0; 2]; 3]; prices.len()];
        for i in 0..prices.len() {
            for k in 1..3 {
                if i == 0 {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = std::cmp::max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = std::cmp::max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        dp[prices.len() - 1][2][0]
    }
}