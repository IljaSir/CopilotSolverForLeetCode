impl Solution {
    pub fn count_paths(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                dp[i][j] = 1;
                if i > 0 && grid[i - 1][j] < grid[i][j] {
                    dp[i][j] += dp[i - 1][j];
                }
                if j > 0 && grid[i][j - 1] < grid[i][j] {
                    dp[i][j] += dp[i][j - 1];
                }
                if i > 0 && j > 0 && grid[i - 1][j - 1] < grid[i][j] {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                dp[i][j] %= 1_000_000_007;
            }
        }
        let mut res = 0;
        for i in 0..m {
            for j in 0..n {
                res += dp[i][j];
                res %= 1_000_000_007;
            }
        }
        res
    }
}