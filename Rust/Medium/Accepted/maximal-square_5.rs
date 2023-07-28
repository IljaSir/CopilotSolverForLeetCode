impl Solution {
    pub fn maximal_square(matrix: Vec<Vec<char>>) -> i32 {
        

        let m = matrix.len();
        let n = matrix[0].len();
        let mut dp: Vec<Vec<i32>> = vec![vec![0; n + 1]; m + 1];
        let mut max = 0;
        for i in 1..m + 1 {
            for j in 1..n + 1 {
                if matrix[i - 1][j - 1] == '1' {
                    dp[i][j] = std::cmp::min(std::cmp::min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = std::cmp::max(max, dp[i][j]);
                }
            }
        }
        max * max
    }
}