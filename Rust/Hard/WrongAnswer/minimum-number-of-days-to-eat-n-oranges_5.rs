impl Solution {
    pub fn min_days(n: i32) -> i32 {
        
        let n = n as i64;
        let mut dp = vec![0; n as usize + 1];
        for i in 1..=n {
            dp[i as usize] = dp[(i / 2) as usize] + dp[(i / 3) as usize] + dp[(i / 5) as usize] + 1;
        }
        dp[n as usize]
    }
}