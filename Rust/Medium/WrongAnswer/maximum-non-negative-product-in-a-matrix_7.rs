impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let modu = 1000000007;
        let mut dp = vec![vec![vec![0; 2]; grid[0].len()]; grid.len()];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for i in 1..grid.len() {
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
        }
        for j in 1..grid[0].len() {
            dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
        }
        for i in 1..grid.len() {
            for j in 1..grid[0].len() {
                let mut min = dp[i - 1][j][0].min(dp[i][j - 1][0]);
                let mut max = dp[i - 1][j][1].max(dp[i][j - 1][1]);
                dp[i][j][0] = min.min(max) * grid[i][j];
                dp[i][j][1] = min.max(max) * grid[i][j];
            }
        }
        if dp[grid.len() - 1][grid[0].len() - 1][0] < 0 {
            -1
        } else {
            (dp[grid.len() - 1][grid[0].len() - 1][0] % modu) as i32
        }
    }
}