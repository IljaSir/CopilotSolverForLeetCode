impl Solution {
    pub fn unique_paths_with_obstacles(obstacle_grid: Vec<Vec<i32>>) -> i32 {
        

        let n = obstacle_grid.len();
        let m = obstacle_grid[0].len();
        if n == 0 || m == 0 {
            return 0;
        }
        let mut dp = vec![vec![0; m]; n];
        for i in 0..n {
            for j in 0..m {
                if obstacle_grid[i][j] == 1 {
                    dp[i][j] = 0;
                } else if i == 0 && j == 0 {
                    dp[i][j] = 1;
                } else if i == 0 {
                    dp[i][j] = dp[i][j-1];
                } else if j == 0 {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        dp[n-1][m-1]
    }
}