impl Solution {
    pub fn knight_dialer(n: i32) -> i32 {
        
        let MOD = 1_000_000_007;
        let mut dp = vec![vec![1; 10]; n as usize];
        for i in 1..n as usize {
            dp[i][0] = (dp[i - 1][4] + dp[i - 1][6]) % MOD;
            dp[i][1] = (dp[i - 1][6] + dp[i - 1][8]) % MOD;
            dp[i][2] = (dp[i - 1][7] + dp[i - 1][9]) % MOD;
            dp[i][3] = (dp[i - 1][4] + dp[i - 1][8]) % MOD;
            dp[i][4] = ((dp[i - 1][3] + dp[i - 1][9]) % MOD + dp[i - 1][0]) % MOD;
            dp[i][5] = 0;
            dp[i][6] = ((dp[i - 1][1] + dp[i - 1][7]) % MOD + dp[i - 1][0]) % MOD;
            dp[i][7] = (dp[i - 1][2] + dp[i - 1][6]) % MOD;
            dp[i][8] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][9] = (dp[i - 1][2] + dp[i - 1][4]) % MOD;
        }
        let mut res = 0;
        for i in 0..10 {
            res = (res + dp[n as usize - 1][i]) % MOD;
        }
        res
    }
}