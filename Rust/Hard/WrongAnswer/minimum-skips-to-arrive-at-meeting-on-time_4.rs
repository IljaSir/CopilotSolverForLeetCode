impl Solution {
    pub fn min_skips(dist: Vec<i32>, speed: i32, hours_before: i32) -> i32 {
        
        let n = dist.len();
        let mut dp = vec![vec![i32::MAX; n+1]; n+1];
        dp[0][0] = 0;
        for i in 0..n {
            let d = dist[i];
            for j in 0..=i {
                if dp[i][j] < i32::MAX {
                    let t = (dp[i][j] * speed + d - 1) / speed;
                    dp[i+1][j] = dp[i+1][j].min(dp[i][j] + t);
                    if j < n {
                        dp[i+1][j+1] = dp[i+1][j+1].min(dp[i][j] + (t-1));
                    }
                }
            }
        }
        let mut ans = i32::MAX;
        for i in 0..=n {
            if dp[n][i] <= hours_before {
                ans = i as i32;
                break;
            }
        }
        if ans == i32::MAX {
            -1
        } else {
            ans
        }
    }
}