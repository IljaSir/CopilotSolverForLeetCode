impl Solution {
    pub fn min_path_sum(grid: Vec<Vec<i32>>) -> i32 {
        

        let (m, n) = (grid.len(), grid[0].len());
        let mut dp = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                if i == 0 && j == 0 {
                    dp[i][j] = grid[i][j];
                } else if i == 0 {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if j == 0 {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + dp[i-1][j].min(dp[i][j-1]);
                }
            }
        }
        dp[m-1][n-1]
    }
}