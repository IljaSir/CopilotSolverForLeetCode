impl Solution {
    pub fn cherry_pickup(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut dp = vec![vec![vec![0; 70]; 70]; 70];
        let n = grid.len();
        let m = grid[0].len();
        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];
        for i in 1..n {
            for j in 0..m {
                for k in 0..m {
                    let mut val = 0;
                    for p in j - 1..j + 2 {
                        for q in k - 1..k + 2 {
                            if p >= 0 && p < m && q >= 0 && q < m {
                                val = std::cmp::max(val, dp[i - 1][p][q]);
                            }
                        }
                    }
                    dp[i][j][k] = val + grid[i][j] + if j != k { grid[i][k] } else { 0 };
                }
            }
        }
        dp[n - 1][m - 1][m - 1]
    }
}