impl Solution {
    pub fn num_tilings(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        dp[0] = 1;
        for i in 1..=n as usize {
            dp[i] = (dp[i - 1] * 2) % 1000000007;
            if i >= 2 {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000007;
            }
            if i >= 3 {
                dp[i] = (dp[i] + dp[i - 3]) % 1000000007;
            }
        }
        dp[n as usize]
    }
}