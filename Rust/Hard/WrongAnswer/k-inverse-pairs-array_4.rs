impl Solution {
    pub fn k_inverse_pairs(n: i32, k: i32) -> i32 {
        
        let n: usize = n as usize;
        let k: usize = k as usize;
        let mut dp = vec![vec![0; k + 1]; n + 1];
        let m = 1_000_000_007;
        dp[0][0] = 1;
        for i in 1..=n {
            dp[i][0] = 1;
            for j in 1..=k {
                dp[i][j] = dp[i][j - 1];
                if j >= i {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] - dp[i - 1][j - i]) % m;
                } else {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % m;
                }
            }
        }
        (dp[n][k] + m) % m
    }
}