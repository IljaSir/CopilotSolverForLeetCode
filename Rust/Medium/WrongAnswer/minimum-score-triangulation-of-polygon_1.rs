impl Solution {
    pub fn min_score_triangulation(values: Vec<i32>) -> i32 {
        
        let n = values.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = values[i];
        }
        for i in (0..n).rev() {
            for j in i+1..n {
                for k in i+1..j {
                    let tmp = dp[i][k] * dp[k][j] + dp[i][j];
                    dp[i][j] = std::cmp::min(dp[i][j], tmp);
                }
            }
        }
        dp[0][n-1]
    }
}