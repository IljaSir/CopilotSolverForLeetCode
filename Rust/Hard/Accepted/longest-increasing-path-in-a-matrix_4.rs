impl Solution {
    pub fn longest_increasing_path(matrix: Vec<Vec<i32>>) -> i32 {
        
        let m = matrix.len();
        let n = matrix[0].len();
        let mut memo = vec![vec![-1; n]; m];
        let mut res = 0;
        for i in 0..m {
            for j in 0..n {
                res = res.max(Self::dfs(&matrix, i, j, &mut memo));
            }
        }
        res
    }
    fn dfs(matrix: &Vec<Vec<i32>>, i: usize, j: usize, memo: &mut Vec<Vec<i32>>) -> i32 {
        if memo[i][j] != -1 {
            return memo[i][j];
        }
        let mut res = 1;
        if i > 0 && matrix[i - 1][j] > matrix[i][j] {
            res = res.max(1 + Self::dfs(matrix, i - 1, j, memo));
        }
        if i < matrix.len() - 1 && matrix[i + 1][j] > matrix[i][j] {
            res = res.max(1 + Self::dfs(matrix, i + 1, j, memo));
        }
        if j > 0 && matrix[i][j - 1] > matrix[i][j] {
            res = res.max(1 + Self::dfs(matrix, i, j - 1, memo));
        }
        if j < matrix[0].len() - 1 && matrix[i][j + 1] > matrix[i][j] {
            res = res.max(1 + Self::dfs(matrix, i, j + 1, memo));
        }
        memo[i][j] = res;
        res
    }
}