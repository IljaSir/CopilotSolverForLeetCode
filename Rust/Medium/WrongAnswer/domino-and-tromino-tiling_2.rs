impl Solution {
    pub fn num_tilings(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        dp[0] = 1;
        for i in 1..=n {
            dp[i] = (dp[i] + dp[i - 1]) % 1_000_000_007;
            if i >= 2 {
                dp[i] = (dp[i] + dp[i - 2]) % 1_000_000_007;
            }
            if i >= 3 {
                dp[i] = (dp[i] + dp[i - 3] * 2) % 1_000_000_007;
            }
        }
        dp[n] as i32
    }
}