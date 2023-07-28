impl Solution {
    pub fn max_product_path(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len() as i32;
        let n = grid[0].len() as i32;
        let mut dp = vec![vec![(1, 1); n as usize]; m as usize];
        dp[0][0] = (grid[0][0], grid[0][0]);
        for i in 1..m {
            let (a, b) = dp[(i - 1) as usize][0];
            dp[i as usize][0] = (a * grid[i as usize][0], b * grid[i as usize][0]);
        }
        for j in 1..n {
            let (a, b) = dp[0][(j - 1) as usize];
            dp[0][j as usize] = (a * grid[0][j as usize], b * grid[0][j as usize]);
        }
        for i in 1..m {
            for j in 1..n {
                let (a, b) = dp[(i - 1) as usize][j as usize];
                let (c, d) = dp[i as usize][(j - 1) as usize];
                let (e, f) = (grid[i as usize][j as usize], grid[i as usize][j as usize]);
                dp[i as usize][j as usize] = (
                    a.max(c).max(b.max(d)) * e.max(f),
                    a.min(c).min(b.min(d)) * e.min(f),
                );
            }
        }
        let (a, b) = dp[(m - 1) as usize][(n - 1) as usize];
        let ans = a.max(b);
        if ans < 0 {
            -1
        } else {
            (ans % 1_000_000_007) as i32
        }
    }
}