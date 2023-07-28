impl Solution {
    pub fn count_squares(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let mut dp = matrix.clone();
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if matrix[i][j] == 1 {
                    if i > 0 && j > 0 {
                        dp[i][j] = (dp[i-1][j-1].min(dp[i-1][j])).min(dp[i][j-1]) + 1;
                    }
                    res += dp[i][j];
                }
            }
        }
        res
    }
}