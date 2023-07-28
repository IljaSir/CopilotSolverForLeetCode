impl Solution {
    pub fn min_skips(dist: Vec<i32>, speed: i32, hours_before: i32) -> i32 {
        
        let n = dist.len();
        let mut dp = vec![vec![std::i32::MAX; n + 1]; n + 1];
        dp[0][0] = 0;
        for i in 0..n {
            let t = (dist[i] + speed - 1) / speed;
            for j in 0..=i {
                if dp[i][j] < std::i32::MAX {
                    dp[i + 1][j] = dp[i + 1][j].min(dp[i][j] + t);
                    if dp[i][j] + t - 1 < hours_before {
                        dp[i + 1][j + 1] = dp[i + 1][j + 1].min(dp[i][j]);
                    }
                }
            }
        }
        for i in 0..=n {
            if dp[n][i] <= hours_before {
                return i as i32;
            }
        }
        -1
    }
}