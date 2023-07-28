impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![(0, 0); n]; m];
        dp[0][0] = (grid[0][0], grid[0][0]);
        for i in 1..m {
            let (a, b) = dp[i - 1][0];
            dp[i][0] = (a * grid[i][0], b * grid[i][0]);
        }
        for j in 1..n {
            let (a, b) = dp[0][j - 1];
            dp[0][j] = (a * grid[0][j], b * grid[0][j]);
        }
        for i in 1..m {
            for j in 1..n {
                let (a, b) = dp[i - 1][j];
                let (c, d) = dp[i][j - 1];
                let (e, f) = dp[i - 1][j - 1];
                let mut g = vec![a * grid[i][j], b * grid[i][j], c * grid[i][j], d * grid[i][j]];
                g.sort();
                dp[i][j] = (g[3], g[0]);
            }
        }
        let (a, b) = dp[m - 1][n - 1];
        let res = if a < 0 { b } else { a };
        if res < 0 {
            -1
        } else {
            (res % 1000000007) as i32
        }
    }
}