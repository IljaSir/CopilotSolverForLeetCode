impl Solution {
    pub fn get_money_amount(n: i32) -> i32 {
        

        let n = n as usize;
        let mut dp = vec![vec![0; n + 1]; n + 1];
        for len in 2..=n {
            for start in 1..=n - len + 1 {
                let end = start + len - 1;
                dp[start][end] = i32::max_value();
                for k in start..=end {
                    let cost = k as i32 + dp[start][k - 1].max(dp[k + 1][end]);
                    dp[start][end] = dp[start][end].min(cost);
                }
            }
        }
        dp[1][n]
    }
}