impl Solution {
    pub fn new21_game(n: i32, k: i32, max_pts: i32) -> f64 {
        
        if k == 0 || n >= k + max_pts {
            return 1.0;
        }
        let mut dp = vec![0.0; n as usize + 1];
        dp[0] = 1.0;
        let mut sum = 1.0;
        for i in 1..=n {
            dp[i] = sum / max_pts as f64;
            if i < k {
                sum += dp[i];
            } else {
                sum += dp[i] - dp[i - max_pts as usize];
            }
        }
        sum
    }
}