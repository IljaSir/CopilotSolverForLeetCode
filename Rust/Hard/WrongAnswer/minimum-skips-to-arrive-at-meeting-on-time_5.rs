impl Solution {
    pub fn min_skips(dist: Vec<i32>, speed: i32, hours_before: i32) -> i32 {
        
        let n = dist.len();
        let mut dp = vec![vec![std::i32::MAX; n]; n];
        dp[0][0] = (dist[0] + speed - 1) / speed;
        for i in 1..n {
            dp[i][0] = dp[i - 1][0] + (dist[i] + speed - 1) / speed;
        }
        for i in 1..n {
            for j in 1..=i {
                dp[i][j] = dp[i - 1][j].min(dp[i - 1][j - 1] + (dist[i] + speed - 1) / speed);
                if dist[i] % speed == 0 {
                    dp[i][j] = dp[i][j].min(dp[i - 1][j - 1] + dist[i] / speed - 1);
                }
            }
        }
        for i in 0..n {
            if dp[n - 1][i] <= hours_before {
                return i as i32;
            }
        }
        -1
    }
}