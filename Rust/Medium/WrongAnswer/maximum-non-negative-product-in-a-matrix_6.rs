impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![vec![vec![1i64; 2]; grid[0].len()]; grid.len()];
        dp[0][0][0] = grid[0][0] as i64;
        dp[0][0][1] = grid[0][0] as i64;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                if i == 0 && j == 0 {
                    continue;
                }
                let mut max = 0;
                let mut min = 0;
                if i > 0 {
                    max = dp[i - 1][j][0];
                    min = dp[i - 1][j][1];
                }
                if j > 0 {
                    max = max.max(dp[i][j - 1][0]);
                    min = min.min(dp[i][j - 1][1]);
                }
                dp[i][j][0] = max * grid[i][j] as i64;
                dp[i][j][1] = min * grid[i][j] as i64;
            }
        }
        if dp[grid.len() - 1][grid[0].len() - 1][0] < 0 {
            -1
        } else {
            (dp[grid.len() - 1][grid[0].len() - 1][0] % 1000000007) as i32
        }
    }
}