impl Solution {
    pub fn count_paths(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![0; n]; m];
        let mut max = 0;
        for i in 0..m {
            for j in 0..n {
                let mut count = 1;
                if i > 0 && grid[i-1][j] < grid[i][j] {
                    count = (count + dp[i-1][j]) % 1000000007;
                }
                if j > 0 && grid[i][j-1] < grid[i][j] {
                    count = (count + dp[i][j-1]) % 1000000007;
                }
                if i < m-1 && grid[i+1][j] < grid[i][j] {
                    count = (count + dp[i+1][j]) % 1000000007;
                }
                if j < n-1 && grid[i][j+1] < grid[i][j] {
                    count = (count + dp[i][j+1]) % 1000000007;
                }
                dp[i][j] = count;
                max = (max + count) % 1000000007;
            }
        }
        max
    }
}