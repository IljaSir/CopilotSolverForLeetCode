impl Solution {
    pub fn new21_game(n: i32, k: i32, max_pts: i32) -> f64 {
        
        if k == 0 || n >= k + max_pts {
            return 1.0;
        }
        let mut dp = vec![0.0; (k + max_pts) as usize];
        for i in k..k + max_pts {
            dp[i as usize] = 1.0;
        }
        dp[k as usize - 1] = (n - k + 1) as f64 / max_pts as f64;
        for i in (0..k).rev() {
            dp[i as usize] = dp[i as usize + 1] - (dp[i as usize + max_pts as usize + 1] - dp[i as usize + 1]) / max_pts as f64;
        }
        dp[0]
    }
}