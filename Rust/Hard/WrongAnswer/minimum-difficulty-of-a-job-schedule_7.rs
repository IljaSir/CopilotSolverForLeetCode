impl Solution {
    pub fn min_difficulty(job_difficulty: Vec<i32>, d: i32) -> i32 {
        
        let n = job_difficulty.len();
        let d = d as usize;
        if n < d {
            return -1;
        }
        let mut dp = vec![vec![i32::max_value(); d + 1]; n + 1];
        dp[0][0] = 0;
        for i in 1..=n {
            for j in 1..=d {
                let mut cur_max = 0;
                for k in (j - 1..i).rev() {
                    cur_max = cur_max.max(job_difficulty[k]);
                    dp[i][j] = dp[i][j].min(dp[k][j - 1] + cur_max);
                }
            }
        }
        dp[n][d]
    }
}