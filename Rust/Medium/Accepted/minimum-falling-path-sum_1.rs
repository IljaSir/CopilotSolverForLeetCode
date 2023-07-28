impl Solution {
    pub fn min_falling_path_sum(matrix: Vec<Vec<i32>>) -> i32 {
        
        let n = matrix.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[0][i] = matrix[0][i];
        }
        for i in 1..n {
            for j in 0..n {
                let mut min = std::i32::MAX;
                if j > 0 {
                    min = min.min(dp[i - 1][j - 1]);
                }
                if j + 1 < n {
                    min = min.min(dp[i - 1][j + 1]);
                }
                min = min.min(dp[i - 1][j]);
                dp[i][j] = min + matrix[i][j];
            }
        }
        let mut res = std::i32::MAX;
        for i in 0..n {
            res = res.min(dp[n - 1][i]);
        }
        res
    }
}