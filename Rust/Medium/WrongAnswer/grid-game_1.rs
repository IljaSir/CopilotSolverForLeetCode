impl Solution {
    pub fn grid_game(grid: Vec<Vec<i32>>) -> i64 {
        
        let n = grid[0].len();
        let mut dp = vec![vec![0; n]; 2];
        dp[0][0] = grid[0][0];
        dp[1][0] = grid[1][0];
        for i in 1..n {
            dp[0][i] = grid[0][i] + dp[0][i-1];
            dp[1][i] = grid[1][i] + dp[1][i-1];
        }
        let mut res = i64::MAX;
        let mut sum = dp[0][n-1] + dp[1][n-1];
        for i in 0..n-1 {
            let cur = dp[0][i] + sum - dp[1][i];
            res = res.min(cur as i64);
        }
        res
    }
}