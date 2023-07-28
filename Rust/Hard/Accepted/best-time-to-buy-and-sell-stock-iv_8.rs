impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![vec![0; prices.len()]; k as usize + 1]; 2];
        let mut max = 0;
        for i in 1..=k {
            for j in 1..prices.len() {
                dp[1][i as usize][j] = dp[1][i as usize][j - 1];
                for k in 0..j {
                    dp[1][i as usize][j] = dp[1][i as usize][j].max(dp[0][i as usize - 1][k] + prices[j] - prices[k]);
                }
                max = max.max(dp[1][i as usize][j]);
            }
            dp[0] = dp[1].clone();
        }
        max
    }
}