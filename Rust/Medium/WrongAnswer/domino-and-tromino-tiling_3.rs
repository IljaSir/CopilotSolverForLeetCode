impl Solution {
    pub fn num_tilings(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        dp[0] = 1;
        for i in 1..=n {
            dp[i] += dp[i - 1];
            if i > 1 {
                dp[i] += dp[i - 2];
            }
            if i > 2 {
                dp[i] += dp[i - 3];
            }
            dp[i] %= 1000000007;
        }
        dp[n]
    }
}