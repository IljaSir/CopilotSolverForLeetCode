impl Solution {
    pub fn cherry_pickup(grid: Vec<Vec<i32>>) -> i32 {
        
        let (m, n) = (grid.len(), grid[0].len());
        let mut dp = vec![vec![vec![0; n]; n]; m];
        for i in (0..m).rev() {
            for j in 0..n {
                for k in 0..n {
                    let mut val = grid[i][j];
                    if j != k {
                        val += grid[i][k];
                    }
                    if i != m - 1 {
                        let mut t = 0;
                        for p in (j as i32-1).max(0) as usize..=(j+1).min(n-1) {
                            for q in (k as i32-1).max(0) as usize..=(k+1).min(n-1) {
                                t = t.max(dp[i+1][p][q]);
                            }
                        }
                        val += t;
                    }
                    dp[i][j][k] = val;
                }
            }
        }
        dp[0][0][n-1]
    }
}