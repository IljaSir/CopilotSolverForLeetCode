impl Solution {
    pub fn count_paths(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![0; n]; m];
        let mut path = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let mut count = 0;
                if i > 0 && grid[i][j] > grid[i-1][j] {
                    count += 1;
                    dp[i][j] += dp[i-1][j];
                    dp[i][j] %= 1000000007;
                    path[i][j] += path[i-1][j];
                    path[i][j] %= 1000000007;
                }
                if j > 0 && grid[i][j] > grid[i][j-1] {
                    count += 1;
                    dp[i][j] += dp[i][j-1];
                    dp[i][j] %= 1000000007;
                    path[i][j] += path[i][j-1];
                    path[i][j] %= 1000000007;
                }
                if i + 1 < m && grid[i][j] > grid[i+1][j] {
                    count += 1;
                    dp[i][j] += dp[i+1][j];
                    dp[i][j] %= 1000000007;
                    path[i][j] += path[i+1][j];
                    path[i][j] %= 1000000007;
                }
                if j + 1 < n && grid[i][j] > grid[i][j+1] {
                    count += 1;
                    dp[i][j] += dp[i][j+1];
                    dp[i][j] %= 1000000007;
                    path[i][j] += path[i][j+1];
                    path[i][j] %= 1000000007;
                }
                if count == 0 {
                    path[i][j] = 1;
                }
                dp[i][j] += path[i][j];
                dp[i][j] %= 1000000007;
            }
        }
        dp[m-1][n-1]
    }
}