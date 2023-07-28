impl Solution {
    pub fn maximal_square(matrix: Vec<Vec<char>>) -> i32 {
        

        let mut dp = vec![vec![0; matrix[0].len()]; matrix.len()];
        let mut max = 0;
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if i == 0 || j == 0 {
                    dp[i][j] = if matrix[i][j] == '1' { 1 } else { 0 };
                } else if matrix[i][j] == '1' {
                    dp[i][j] = 1 + std::cmp::min(dp[i - 1][j - 1], std::cmp::min(dp[i - 1][j], dp[i][j - 1]));
                }
                max = std::cmp::max(max, dp[i][j]);
            }
        }
        max * max
    }
}