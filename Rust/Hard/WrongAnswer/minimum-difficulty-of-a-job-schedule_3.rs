impl Solution {
    pub fn min_difficulty(job_difficulty: Vec<i32>, d: i32) -> i32 {
        
        let n = job_difficulty.len();
        if n < d as usize {
            return -1;
        }
        let mut dp = vec![vec![i32::MAX; n + 1]; d as usize + 1];
        dp[0][0] = 0;
        for i in 1..=d as usize {
            for j in i..=n {
                let mut max = 0;
                for k in (i - 1)..j {
                    max = max.max(job_difficulty[k]);
                    dp[i][j] = dp[i][j].min(dp[i - 1][k] + max);
                }
            }
        }
        dp[d as usize][n]
    }
}