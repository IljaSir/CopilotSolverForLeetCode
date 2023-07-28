impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        for i in 1..=n {
            dp[i] = 1 + dp[i - 1];
            for j in 1..i {
                dp[i] = dp[i].min(1 + j.max(dp[i - j]));
            }
        }
        dp[n] as i32
    }
}