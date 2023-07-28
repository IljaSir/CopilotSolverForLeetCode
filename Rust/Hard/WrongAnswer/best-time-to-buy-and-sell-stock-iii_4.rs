impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 3]; prices.len()];
        for i in 1..prices.len() {
            let diff = prices[i] - prices[i - 1];
            for j in 1..3 {
                dp[i][j] = std::cmp::max(dp[i - 1][j], dp[i - 1][j - 1] + diff);
            }
        }
        dp[prices.len() - 1][2]
    }
}