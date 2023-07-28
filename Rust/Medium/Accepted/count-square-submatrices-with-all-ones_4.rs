impl Solution {
    pub fn count_squares(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![vec![0; matrix[0].len()]; matrix.len()];
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if matrix[i][j] == 1 {
                    if i == 0 || j == 0 {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + dp[i - 1][j].min(dp[i][j - 1]).min(dp[i - 1][j - 1]);
                    }
                }
            }
        }
        let mut res = 0;
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                res += dp[i][j];
            }
        }
        res
    }
}