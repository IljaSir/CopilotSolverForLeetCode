impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let modu = 1_000_000_007;
        let (m, n) = (grid.len(), grid[0].len());
        let mut dp = vec![vec![(1, 1); n]; m];
        dp[0][0] = (grid[0][0], grid[0][0]);
        for i in 0..m {
            for j in 0..n {
                if i > 0 || j > 0 {
                    let mut tmp = vec![];
                    if i > 0 {
                        let (a, b) = dp[i - 1][j];
                        tmp.push((a * grid[i][j], b * grid[i][j]));
                    }
                    if j > 0 {
                        let (a, b) = dp[i][j - 1];
                        tmp.push((a * grid[i][j], b * grid[i][j]));
                    }
                    let mut min = std::i32::MAX;
                    let mut max = std::i32::MIN;
                    for (a, b) in tmp {
                        min = min.min(a).min(b);
                        max = max.max(a).max(b);
                    }
                    dp[i][j] = (min, max);
                }
            }
        }
        let (a, b) = dp[m - 1][n - 1];
        if b < 0 {
            -1
        } else {
            (a % modu) as i32
        }
    }
}