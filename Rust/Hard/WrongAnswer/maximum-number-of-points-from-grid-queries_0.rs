impl Solution {
    pub fn max_points(grid: Vec<Vec<i32>>, queries: Vec<i32>) -> Vec<i32> {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut dp = vec![vec![0; n + 1]; m + 1];
        for i in 1..=m {
            for j in 1..=n {
                dp[i][j] = grid[i - 1][j - 1] + dp[i - 1][j].max(dp[i][j - 1]);
            }
        }
        let mut res = vec![];
        for q in &queries {
            let mut max = 0;
            for i in 1..=m {
                for j in 1..=n {
                    if grid[i - 1][j - 1] <= *q {
                        max = max.max(dp[i][j]);
                    }
                }
            }
            res.push(max);
        }
        res
    }
}