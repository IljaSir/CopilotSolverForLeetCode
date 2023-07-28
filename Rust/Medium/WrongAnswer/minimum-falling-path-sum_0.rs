impl Solution {
    pub fn min_falling_path_sum(matrix: Vec<Vec<i32>>) -> i32 {
        
        let n = matrix.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[0][i] = matrix[0][i];
        }
        for i in 1..n {
            for j in 0..n {
                dp[i][j] = matrix[i][j] + dp[i - 1][j].min(dp[i - 1][(j + n - 1) % n].min(dp[i - 1][(j + 1) % n]));
            }
        }
        dp[n - 1].iter().min().unwrap().clone()
    }
}