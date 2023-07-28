impl Solution {
    pub fn longest_increasing_path(matrix: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (matrix.len(), matrix[0].len());
        let mut dp = vec![vec![0; n]; m];
        let mut res = 0;
        for i in 0..m {
            for j in 0..n {
                res = res.max(Self::dfs(&matrix, i, j, &mut dp));
            }
        }
        res
    }
    fn dfs(matrix: &[Vec<i32>], i: usize, j: usize, dp: &mut Vec<Vec<i32>>) -> i32 {
        if dp[i][j] != 0 {
            return dp[i][j];
        }
        let (m, n) = (matrix.len(), matrix[0].len());
        let mut res = 1;
        if i > 0 && matrix[i][j] < matrix[i - 1][j] {
            res = res.max(Self::dfs(matrix, i - 1, j, dp) + 1);
        }
        if i < m - 1 && matrix[i][j] < matrix[i + 1][j] {
            res = res.max(Self::dfs(matrix, i + 1, j, dp) + 1);
        }
        if j > 0 && matrix[i][j] < matrix[i][j - 1] {
            res = res.max(Self::dfs(matrix, i, j - 1, dp) + 1);
        }
        if j < n - 1 && matrix[i][j] < matrix[i][j + 1] {
            res = res.max(Self::dfs(matrix, i, j + 1, dp) + 1);
        }
        dp[i][j] = res;
        res
    }
}