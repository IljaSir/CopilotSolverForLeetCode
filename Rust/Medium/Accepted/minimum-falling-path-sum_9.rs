impl Solution {
    pub fn min_falling_path_sum(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = matrix.clone();
        for i in 1..dp.len() {
            for j in 0..dp.len() {
                dp[i][j] = dp[i][j] + dp[i - 1][j];
                if j > 0 {
                    dp[i][j] = dp[i][j].min(dp[i - 1][j - 1] + matrix[i][j]);
                }
                if j + 1 < dp.len() {
                    dp[i][j] = dp[i][j].min(dp[i - 1][j + 1] + matrix[i][j]);
                }
            }
        }
        *dp.last().unwrap().iter().min().unwrap()
    }
}