impl Solution {
    pub fn min_days(n: i32) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        for i in 2..=n {
            dp[i as usize] = 1 + dp[(i - 1) as usize].min(dp[(i % 2 + i / 2) as usize].min(dp[(i % 3 + i / 3 * 2) as usize]));
        }
        dp[n as usize]
    }
}