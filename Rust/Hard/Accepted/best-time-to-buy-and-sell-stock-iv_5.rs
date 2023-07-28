impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; prices.len()]; k as usize + 1];
        for t in 1..=k as usize {
            let mut tmp_max = dp[t-1][0] - prices[0];
            for d in 1..prices.len() {
                dp[t][d] = std::cmp::max(dp[t][d-1], tmp_max + prices[d]);
                tmp_max = std::cmp::max(tmp_max, dp[t-1][d] - prices[d]);
            }
        }
        dp[k as usize][prices.len() - 1]
    }
}