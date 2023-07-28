impl Solution {
    pub fn count_orders(n: i32) -> i32 {
        
        let mut dp = vec![0; (n+1) as usize];
        dp[1] = 1;
        for i in 2..=n {
            let i = i as usize;
            dp[i] = ((i-1) as i64 * (dp[i-1] as i64 + dp[i-2] as i64)) as i32 % 1_000_000_007;
        }
        dp[n as usize]
    }
}