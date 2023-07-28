impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        

        let mut dp = vec![vec![0, 0, 0]; prices.len()];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for i in 1..prices.len() {
            dp[i][0] = dp[i-1][0].max(dp[i-1][1] + prices[i]);
            dp[i][1] = dp[i-1][1].max(dp[i-1][2] - prices[i]);
            dp[i][2] = dp[i-1][0];
        }
        dp[prices.len()-1][0]
    }
}