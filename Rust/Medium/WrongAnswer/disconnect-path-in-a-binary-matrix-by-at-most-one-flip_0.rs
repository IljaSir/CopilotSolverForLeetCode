impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![0; n]; m];
        dp[0][0] = 1;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 0 {
                    continue;
                }
                if i > 0 {
                    dp[i][j] += dp[i-1][j];
                }
                if j > 0 {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        if dp[m-1][n-1] > 1 {
            return true;
        }
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    continue;
                }
                let mut count = 0;
                if i > 0 && grid[i-1][j] == 1 {
                    count += dp[i-1][j];
                }
                if i < m-1 && grid[i+1][j] == 1 {
                    count += dp[m-1][n-1] - dp[i][j];
                }
                if j > 0 && grid[i][j-1] == 1 {
                    count += dp[i][j-1];
                }
                if j < n-1 && grid[i][j+1] == 1 {
                    count += dp[m-1][n-1] - dp[i][j];
                }
                if count > 1 {
                    return true;
                }
            }
        }
        false
    }
}