impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let n = prices.len();
        if n < 2 {
            return 0;
        }
        let k = k as usize;
        let mut dp = vec![vec![0; n]; 2];
        for i in 1..=k {
            let mut max_diff = -prices[0];
            for j in 1..n {
                dp[i % 2][j] = std::cmp::max(dp[i % 2][j - 1], prices[j] + max_diff);
                max_diff = std::cmp::max(max_diff, dp[(i - 1) % 2][j - 1] - prices[j]);
            }
        }
        dp[k % 2][n - 1]
    }
}