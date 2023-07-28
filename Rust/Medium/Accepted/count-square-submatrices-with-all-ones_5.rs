impl Solution {
    pub fn count_squares(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![vec![0; matrix[0].len()]; matrix.len()];
        let mut result = 0;
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if i == 0 || j == 0 {
                    dp[i][j] = matrix[i][j];
                } else if matrix[i][j] == 1 {
                    dp[i][j] = 1 + std::cmp::min(std::cmp::min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
                result += dp[i][j];
            }
        }
        result
    }
}