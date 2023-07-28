impl Solution {
    pub fn distinct_sequences(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![0; 7]; n+1];
        let mut sum = vec![vec![0; 7]; n+1];
        let mut res = 0;
        for i in 1..=6 {
            dp[1][i] = 1;
            sum[1][i] = 1;
        }
        for i in 2..=n {
            for j in 1..=6 {
                for k in 1..=6 {
                    if j == k || j % k != 0 && k % j != 0 {
                        dp[i][j] += sum[i-1][k];
                        dp[i][j] %= 1_000_000_007;
                    }
                }
                sum[i][j] = sum[i][j-1] + dp[i][j];
                sum[i][j] %= 1_000_000_007;
            }
        }
        for i in 1..=6 {
            res += dp[n][i];
            res %= 1_000_000_007;
        }
        res as i32
    }
}