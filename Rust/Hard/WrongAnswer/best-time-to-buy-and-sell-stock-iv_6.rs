impl Solution {
    pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
        
        let k = k as usize;
        let n = prices.len();
        if k >= n / 2 {
            return Self::max_profit_k_inf(prices);
        }
        let mut dp = vec![vec![0; n]; k + 1];
        for i in 1..=k {
            let mut tmp_max = -prices[0];
            for j in 1..n {
                dp[i][j] = dp[i][j - 1].max(prices[j] + tmp_max);
                tmp_max = tmp_max.max(dp[i - 1][j - 1] - prices[j]);
            }
        }
        dp[k][n - 1]
    }

    fn max_profit_k_inf(prices: Vec<i32>) -> i32 {
        let mut res = 0;
        for i in 1..prices.len() {
            res += prices[i].max(0) - prices[i - 1].max(0);
        }
        res
    }
}