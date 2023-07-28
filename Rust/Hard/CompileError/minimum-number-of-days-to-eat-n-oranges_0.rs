impl Solution {
    pub fn min_days(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        dp[0] = 0;
        dp[1] = 1;
        for i in 2..=n as usize {
            dp[i] = (dp[i/2] + i%2 + 1).min(dp[i/3] + i%3 + 1);
        }
        dp[n as usize]
    }
}