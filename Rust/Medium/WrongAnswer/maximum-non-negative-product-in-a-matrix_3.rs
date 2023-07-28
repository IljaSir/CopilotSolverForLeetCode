impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![vec![0; 2]; n]; m];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for i in 1..m {
            dp[i][0][0] = dp[i-1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i-1][0][1] * grid[i][0];
        }
        for j in 1..n {
            dp[0][j][0] = dp[0][j-1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j-1][1] * grid[0][j];
        }
        for i in 1..m {
            for j in 1..n {
                dp[i][j][0] = dp[i-1][j][0].max(dp[i][j-1][0]) * grid[i][j];
                dp[i][j][1] = dp[i-1][j][1].min(dp[i][j-1][1]) * grid[i][j];
            }
        }
        if dp[m-1][n-1][0] < 0 {
            -1
        } else {
            (dp[m-1][n-1][0] % 1_000_000_007) as i32
        }
    }
}