impl Solution {
    pub fn num_tilings(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![0; 3]; n+1];
        dp[0][0] = 1;
        for i in 1..=n {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 1_000_000_007;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 1_000_000_007;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 1_000_000_007;
        }
        dp[n][0]
    }
}