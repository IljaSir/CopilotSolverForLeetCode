impl Solution {
    pub fn knight_dialer(n: i32) -> i32 {
        
        let mut dp = vec![vec![0; 10]; n as usize];
        let mod_val = 1_000_000_000 + 7;
        for i in 0..10 {
            dp[0][i] = 1;
        }
        for i in 1..n as usize {
            dp[i][0] = (dp[i - 1][4] + dp[i - 1][6]) % mod_val;
            dp[i][1] = (dp[i - 1][6] + dp[i - 1][8]) % mod_val;
            dp[i][2] = (dp[i - 1][7] + dp[i - 1][9]) % mod_val;
            dp[i][3] = (dp[i - 1][4] + dp[i - 1][8]) % mod_val;
            dp[i][4] = ((dp[i - 1][3] + dp[i - 1][9]) % mod_val + dp[i - 1][0]) % mod_val;
            dp[i][5] = 0;
            dp[i][6] = ((dp[i - 1][1] + dp[i - 1][7]) % mod_val + dp[i - 1][0]) % mod_val;
            dp[i][7] = (dp[i - 1][2] + dp[i - 1][6]) % mod_val;
            dp[i][8] = (dp[i - 1][1] + dp[i - 1][3]) % mod_val;
            dp[i][9] = (dp[i - 1][2] + dp[i - 1][4]) % mod_val;
        }
        let mut res = 0;
        for i in 0..10 {
            res = (res + dp[n as usize - 1][i]) % mod_val;
        }
        res
    }
}