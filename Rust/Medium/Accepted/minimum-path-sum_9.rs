impl Solution {
    pub fn min_path_sum(grid: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = vec![vec![0; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if i == 0 && j == 0 {
                    dp[i][j] = grid[i][j];
                } else if i == 0 {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if j == 0 {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = dp[i-1][j].min(dp[i][j-1]) + grid[i][j];
                }
            }
        }
        dp[grid.len()-1][grid[0].len()-1]
    }
}