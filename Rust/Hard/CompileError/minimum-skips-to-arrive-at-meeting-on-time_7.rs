impl Solution {
    pub fn min_skips(dist: Vec<i32>, speed: i32, hours_before: i32) -> i32 {
        
        let n = dist.len();
        let mut dp = vec![vec![vec![0; n+1]; n+1]; 2];
        for i in 0..n+1 {
            for j in 0..n+1 {
                dp[0][i][j] = i32::MAX;
                dp[1][i][j] = i32::MAX;
            }
        }
        dp[0][0][0] = 0;
        for i in 0..n {
            for j in 0..n+1 {
                for k in 0..n+1 {
                    if dp[0][j][k] == i32::MAX {
                        continue;
                    }
                    let t = dist[i] * speed - dp[0][j][k];
                    let t = if t % speed == 0 { t / speed } else { t / speed + 1 };
                    if t + j <= i {
                        dp[0][j+t][k] = 0;
                    }
                    if t + j + 1 <= i {
                        dp[1][j+t+1][k] = 0;
                    }
                    if k > 0 {
                        dp[0][j+1][k-1] = if dp[0][j+1][k-1] == i32::MAX { dist[i] * speed } else { dp[0][j+1][k-1].min(dist[i] * speed) };
                    }
                }
            }
            for j in 0..n+1 {
                for k in 0..n+1 {
                    if dp[1][j][k] == i32::MAX {
                        continue;
                    }
                    let t = dist[i] * speed - dp[1][j][k];
                    let t = if t % speed == 0 { t / speed } else { t / speed + 1 };
                    if t + j <= i {
                        dp[1][j+t][k] = 0;
                    }
                    if t + j + 1 <= i {
                        dp[0][j+t+1][k] = 0;
                    }
                    if k > 0 {
                        dp[1][j+1][k-1] = if dp[1][j+1][k-1] == i32::
    }
}