impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let n = prices.len();
        if n < 2 {
            return 0;
        }
        let mut dp = vec![vec![0; n]; 3];
        for i in 1..=2 {
            let mut tmp_max = dp[i-1][0] - prices[0];
            for j in 1..n {
                dp[i][j] = dp[i][j-1].max(tmp_max + prices[j]);
                tmp_max = tmp_max.max(dp[i-1][j] - prices[j]);
            }
        }
        dp[2][n-1]
    }
}