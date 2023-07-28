impl Solution {
    pub fn number_of_paths(grid: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![0; n]; m];
        dp[0][0] = 1;
        for i in 0..m {
            for j in 0..n {
                if i > 0 {
                    dp[i][j] += dp[i-1][j];
                }
                if j > 0 {
                    dp[i][j] += dp[i][j-1];
                }
                dp[i][j] %= k;
            }
        }
        dp[m-1][n-1]
    }
}