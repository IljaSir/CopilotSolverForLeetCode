impl Solution {
    pub fn min_difficulty(job_difficulty: Vec<i32>, d: i32) -> i32 {
        
        let n = job_difficulty.len();
        let d = d as usize;
        let mut dp = vec![vec![0; n]; d];
        dp[0][0] = job_difficulty[0];
        for i in 1..n {
            dp[0][i] = job_difficulty[i].max(dp[0][i-1]);
        }
        for i in 1..d {
            for j in i..n {
                let mut m = job_difficulty[j];
                dp[i][j] = i32::MAX;
                for k in (i-1..j).rev() {
                    m = m.max(job_difficulty[k]);
                    dp[i][j] = dp[i][j].min(dp[i-1][k] + m);
                }
            }
        }
        dp[d-1][n-1]
    }
}