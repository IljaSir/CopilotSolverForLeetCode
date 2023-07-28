impl Solution {
    pub fn largest_submatrix(matrix: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (matrix.len(), matrix[0].len());
        let mut dp = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                if matrix[i][j] == 1 {
                    dp[i][j] = 1 + if i > 0 { dp[i - 1][j] } else { 0 };
                }
            }
        }
        let mut res = 0;
        for i in 0..m {
            dp[i].sort_unstable();
            for j in 0..n {
                res = res.max(dp[i][j] * (n - j) as i32);
            }
        }
        res
    }
}