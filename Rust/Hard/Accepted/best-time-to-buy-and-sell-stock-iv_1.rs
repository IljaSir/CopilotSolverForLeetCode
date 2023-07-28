impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let k = k as usize;
        let n = prices.len();
        if n == 0 {
            return 0;
        }
        let mut dp = vec![vec![0; n]; k + 1];
        for i in 1..=k {
            let mut min_cost = prices[0];
            for j in 1..n {
                min_cost = min_cost.min(prices[j] - dp[i - 1][j - 1]);
                dp[i][j] = dp[i][j - 1].max(prices[j] - min_cost);
            }
        }
        dp[k][n - 1]
    }
}