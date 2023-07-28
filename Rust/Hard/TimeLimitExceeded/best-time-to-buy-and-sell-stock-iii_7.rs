impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 3]; prices.len() + 1];
        for i in 1..=prices.len() {
            for j in 1..=2 {
                let mut max = dp[i - 1][j];
                for k in 0..i {
                    max = max.max(dp[k][j - 1] + prices[i - 1] - prices[k]);
                }
                dp[i][j] = max;
            }
        }
        dp[prices.len()][2]
    }
}