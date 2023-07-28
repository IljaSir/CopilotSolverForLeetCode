impl Solution {
    pub fn min_difficulty(job_difficulty: Vec<i32>, d: i32) -> i32 {
        
        let n = job_difficulty.len();
        let d = d as usize;
        if n < d {
            return -1;
        }
        let mut dp = vec![vec![0; n]; d];
        dp[0][0] = job_difficulty[0];
        for i in 1..n {
            dp[0][i] = dp[0][i - 1].max(job_difficulty[i]);
        }
        for i in 1..d {
            for j in i..n {
                dp[i][j] = i32::MAX;
                let mut max = 0;
                for k in (i - 1..j).rev() {
                    max = max.max(job_difficulty[k + 1]);
                    dp[i][j] = dp[i][j].min(dp[i - 1][k] + max);
                }
            }
        }
        dp[d - 1][n - 1]
    }
}