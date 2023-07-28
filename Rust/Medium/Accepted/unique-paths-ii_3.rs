impl Solution {
    pub fn unique_paths_with_obstacles(obstacle_grid: Vec<Vec<i32>>) -> i32 {
        

        let m = obstacle_grid.len();
        let n = obstacle_grid[0].len();
        let mut dp = vec![vec![0; n]; m];
        dp[0][0] = if obstacle_grid[0][0] == 1 { 0 } else { 1 };
        for i in 1..m {
            dp[i][0] = if obstacle_grid[i][0] == 1 { 0 } else { dp[i - 1][0] };
        }
        for j in 1..n {
            dp[0][j] = if obstacle_grid[0][j] == 1 { 0 } else { dp[0][j - 1] };
        }
        for i in 1..m {
            for j in 1..n {
                dp[i][j] = if obstacle_grid[i][j] == 1 { 0 } else { dp[i - 1][j] + dp[i][j - 1] };
            }
        }
        dp[m - 1][n - 1]
    }
}