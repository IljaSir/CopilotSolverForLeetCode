impl Solution {
    pub fn min_days(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        for i in 1..=n as usize {
            dp[i] = dp[i - 1] + 1;
            if i % 2 == 0 {
                dp[i] = dp[i].min(dp[i / 2] + 1);
            }
            if i % 3 == 0 {
                dp[i] = dp[i].min(dp[i / 3] + 1);
            }
        }
        dp[n as usize]
    }
}