impl Solution {
    pub fn number_of_paths(grid: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![0; n]; m];
        dp[0][0] = grid[0][0];
        for i in 1..m {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for j in 1..n {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for i in 1..m {
            for j in 1..n {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + grid[i][j];
            }
        }
        let mut ans = 0;
        for i in 0..m {
            for j in 0..n {
                for x in i..m {
                    for y in j..n {
                        let mut sum = dp[x][y];
                        if i > 0 {
                            sum -= dp[i - 1][y];
                        }
                        if j > 0 {
                            sum -= dp[x][j - 1];
                        }
                        if i > 0 && j > 0 {
                            sum += dp[i - 1][j - 1];
                        }
                        if sum % k == 0 {
                            ans += 1;
                        }
                    }
                }
            }
        }
        ans
    }
}