impl Solution {
    pub fn min_difficulty(job_difficulty: Vec<i32>, d: i32) -> i32 {
        
        let d = d as usize;
        let mut dp = vec![vec![-1; job_difficulty.len()+1]; d+1];
        dp[0][0] = 0;
        for i in 1..=d {
            for j in i..=job_difficulty.len() {
                let mut max = 0;
                for k in (i-1)..j {
                    max = max.max(job_difficulty[k]);
                    if dp[i-1][k] != -1 {
                        dp[i][j] = dp[i][j].min(dp[i-1][k] + max).max(-1);
                    }
                }
            }
        }
        dp[d][job_difficulty.len()]
    }
}