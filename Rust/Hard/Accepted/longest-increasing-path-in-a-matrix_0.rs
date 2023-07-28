impl Solution {
    pub fn longest_increasing_path(matrix: Vec<Vec<i32>>) -> i32 {
        
        if matrix.is_empty() {
            return 0;
        }
        let m = matrix.len();
        let n = matrix[0].len();
        let mut dp = vec![vec![0; n]; m];
        let mut ans = 0;
        for i in 0..m {
            for j in 0..n {
                ans = ans.max(Solution::dfs(&matrix, i, j, &mut dp));
            }
        }
        ans
    }
    fn dfs(matrix: &Vec<Vec<i32>>, i: usize, j: usize, dp: &mut Vec<Vec<i32>>) -> i32 {
        if dp[i][j] != 0 {
            return dp[i][j];
        }
        let m = matrix.len();
        let n = matrix[0].len();
        let mut ans = 1;
        if i > 0 && matrix[i - 1][j] > matrix[i][j] {
            ans = ans.max(Solution::dfs(matrix, i - 1, j, dp) + 1);
        }
        if i + 1 < m && matrix[i + 1][j] > matrix[i][j] {
            ans = ans.max(Solution::dfs(matrix, i + 1, j, dp) + 1);
        }
        if j > 0 && matrix[i][j - 1] > matrix[i][j] {
            ans = ans.max(Solution::dfs(matrix, i, j - 1, dp) + 1);
        }
        if j + 1 < n && matrix[i][j + 1] > matrix[i][j] {
            ans = ans.max(Solution::dfs(matrix, i, j + 1, dp) + 1);
        }
        dp[i][j] = ans;
        ans
    }
}