impl Solution {
    pub fn min_falling_path_sum(matrix: Vec<Vec<i32>>) -> i32 {
        
        let n = matrix.len();
        let mut dp = matrix;
        for i in 1..n {
            for j in 0..n {
                if j == 0 {
                    dp[i][j] += dp[i-1][j].min(dp[i-1][j+1]);
                } else if j == n-1 {
                    dp[i][j] += dp[i-1][j].min(dp[i-1][j-1]);
                } else {
                    dp[i][j] += dp[i-1][j-1].min(dp[i-1][j]).min(dp[i-1][j+1]);
                }
            }
        }
        dp[n-1].iter().min().unwrap().to_owned()
    }
}