impl Solution {
    pub fn longest_increasing_path(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![vec![-1; matrix[0].len()]; matrix.len()];
        let mut max = 0;
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                max = max.max(Solution::dfs(i, j, &matrix, &mut dp));
            }
        }
        max
    }
    fn dfs(i: usize, j: usize, matrix: &Vec<Vec<i32>>, dp: &mut Vec<Vec<i32>>) -> i32 {
        if dp[i][j] != -1 {
            return dp[i][j];
        }
        let mut max = 1;
        if i > 0 && matrix[i][j] < matrix[i - 1][j] {
            max = max.max(Solution::dfs(i - 1, j, matrix, dp) + 1);
        }
        if i < matrix.len() - 1 && matrix[i][j] < matrix[i + 1][j] {
            max = max.max(Solution::dfs(i + 1, j, matrix, dp) + 1);
        }
        if j > 0 && matrix[i][j] < matrix[i][j - 1] {
            max = max.max(Solution::dfs(i, j - 1, matrix, dp) + 1);
        }
        if j < matrix[0].len() - 1 && matrix[i][j] < matrix[i][j + 1] {
            max = max.max(Solution::dfs(i, j + 1, matrix, dp) + 1);
        }
        dp[i][j] = max;
        max
    }
}