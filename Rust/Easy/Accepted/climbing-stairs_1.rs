impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        dp[0] = 1;
        for i in 0..n {
            dp[i + 1] += dp[i];
            if i < n - 1 {
                dp[i + 2] += dp[i];
            }
        }
        dp[n]
    }
}