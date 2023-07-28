impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let n = prices.len();
        if n < 2 {
            return 0;
        }
        if k >= n as i32 {
            return Self::max_profit_unlimited(prices);
        }
        let mut dp = vec![vec![0; n]; k as usize + 1];
        for i in 1..=k as usize {
            let mut max = -prices[0];
            for j in 1..n {
                dp[i][j] = dp[i][j - 1].max(prices[j] + max);
                max = max.max(dp[i - 1][j - 1] - prices[j]);
            }
        }
        dp[k as usize][n - 1]
    }
    fn max_profit_unlimited(prices: Vec<i32>) -> i32 {
        let mut profit = 0;
        for i in 1..prices.len() {
            if prices[i] > prices[i - 1] {
                profit += prices[i] - prices[i - 1];
            }
        }
        profit
    }
}