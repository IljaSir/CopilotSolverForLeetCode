impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mod_num = 1000000007;
        let mut dp = vec![vec![(0, 0); n]; m];
        dp[0][0] = (grid[0][0], grid[0][0]);
        for i in 0..m {
            for j in 0..n {
                if i == 0 && j == 0 {
                    continue;
                }
                if i == 0 {
                    let (min_val, max_val) = dp[i][j - 1];
                    dp[i][j] = (min_val * grid[i][j], max_val * grid[i][j]);
                    continue;
                }
                if j == 0 {
                    let (min_val, max_val) = dp[i - 1][j];
                    dp[i][j] = (min_val * grid[i][j], max_val * grid[i][j]);
                    continue;
                }
                let (min_val1, max_val1) = dp[i][j - 1];
                let (min_val2, max_val2) = dp[i - 1][j];
                dp[i][j] = (
                    min_val1.min(min_val2) * grid[i][j],
                    max_val1.max(max_val2) * grid[i][j],
                );
            }
        }
        let (min_val, max_val) = dp[m - 1][n - 1];
        if min_val > 0 {
            (max_val % mod_num) as i32
        } else {
            -1
        }
    }
}