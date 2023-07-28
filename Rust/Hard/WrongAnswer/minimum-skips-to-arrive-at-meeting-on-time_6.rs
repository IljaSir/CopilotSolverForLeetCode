impl Solution {
    pub fn min_skips(dist: Vec<i32>, speed: i32, hours_before: i32) -> i32 {
        
        let n = dist.len();
        let mut dp = vec![vec![0; n+1]; n+1];
        dp[0][0] = 0;
        for i in 1..=n {
            dp[i][0] = (dp[i-1][0] + dist[i-1] + speed - 1) / speed;
        }
        for i in 1..=n {
            for j in 1..=n {
                dp[i][j] = (dp[i-1][j] + dist[i-1] + speed - 1) / speed;
                if dp[i-1][j-1] * speed >= dist[i-1] {
                    dp[i][j] = dp[i][j].min(dp[i-1][j-1]);
                } else {
                    dp[i][j] = dp[i][j].min(dp[i-1][j-1] + 1);
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