impl Solution {
    pub fn min_path_sum(grid: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = vec![vec![0; grid[0].len()]; grid.len()];
        dp[0][0] = grid[0][0];
        for i in 1..dp.len() {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for j in 1..dp[0].len() {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for i in 1..dp.len() {
            for j in 1..dp[0].len() {
                dp[i][j] = grid[i][j] + dp[i-1][j].min(dp[i][j-1]);
            }
        }
        dp[dp.len()-1][dp[0].len()-1]
    }
}