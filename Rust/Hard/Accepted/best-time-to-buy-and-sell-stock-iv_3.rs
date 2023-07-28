impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; prices.len()]; k as usize + 1];
        for i in 1..=k as usize {
            let mut tmp_max = dp[i-1][0] - prices[0];
            for j in 1..prices.len() {
                dp[i][j] = std::cmp::max(dp[i][j-1], prices[j] + tmp_max);
                tmp_max = std::cmp::max(tmp_max, dp[i-1][j] - prices[j]);
            }
        }
        dp[k as usize][prices.len() - 1]
    }
}