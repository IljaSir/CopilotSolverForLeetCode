impl Solution {
    pub fn new21_game(n: i32, k: i32, max_pts: i32) -> f64 {
        
        if k == 0 {
            return 1.0;
        }
        let n = n as usize;
        let k = k as usize;
        let max_pts = max_pts as usize;
        let mut dp = vec![0.0; n + 1];
        dp[0] = 1.0;
        let mut sum = 0.0;
        for i in 1..=n {
            if i <= max_pts {
                sum += dp[i - 1];
            }
            if i > max_pts {
                sum += dp[i - 1] - dp[i - max_pts - 1];
            }
            if i >= k {
                sum -= dp[i - k];
            }
            dp[i] = sum;
        }
        dp[n] / max_pts as f64
    }
}