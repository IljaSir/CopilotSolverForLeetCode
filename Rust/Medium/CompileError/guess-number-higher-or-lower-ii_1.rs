impl Solution {
    pub fn get_money_amount(n: i32) -> i32 {
        

        let n = n as usize;
        let mut dp = vec![vec![0; n + 1]; n + 1];
        for l in (1..n).rev() {
            for r in (l + 1..=n).rev() {
                let mut min = std::i32::MAX;
                for m in l..=r {
                    let cur = m + dp[l][m - 1].max(dp[m + 1][r]);
                    min = min.min(cur);
                }
                dp[l][r] = min;
            }
        }
        dp[1][n]
    }
}