impl Solution {
    pub fn min_difficulty(job_difficulty: Vec<i32>, d: i32) -> i32 {
        
        let n = job_difficulty.len();
        let d = d as usize;
        if n < d {
            return -1;
        }
        let mut dp = vec![vec![i32::max_value(); n]; d];
        dp[0][0] = job_difficulty[0];
        for i in 1..n {
            dp[0][i] = dp[0][i - 1].max(job_difficulty[i]);
        }
        for i in 1..d {
            for j in i..n {
                let mut max = job_difficulty[j];
                dp[i][j] = dp[i - 1][j - 1] + max;
                for k in (i..j).rev() {
                    max = max.max(job_difficulty[k]);
                    dp[i][j] = dp[i][j].min(dp[i - 1][k - 1] + max);
                }
            }
        }
        dp[d - 1][n - 1]
    }
}