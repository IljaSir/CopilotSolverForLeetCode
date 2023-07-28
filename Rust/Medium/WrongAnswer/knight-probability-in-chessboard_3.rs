impl Solution {
    pub fn knight_probability(n: i32, k: i32, row: i32, column: i32) -> f64 {
        

        let (n, k, row, column) = (n as usize, k as usize, row as usize, column as usize);
        let mut dp = vec![vec![vec![0.0; n]; n]; k+1];
        for i in 0..n {
            for j in 0..n {
                dp[0][i][j] = 1.0;
            }
        }
        let mut res = 0.0;
        for i in 1..=k {
            for j in 0..n {
                for l in 0..n {
                    let mut cnt = 0;
                    if j > 1 && l > 0 { cnt += 1; dp[i][j][l] += dp[i-1][j-2][l-1]; }
                    if j > 1 && l < n-1 { cnt += 1; dp[i][j][l] += dp[i-1][j-2][l+1]; }
                    if j > 0 && l > 1 { cnt += 1; dp[i][j][l] += dp[i-1][j-1][l-2]; }
                    if j > 0 && l < n-2 { cnt += 1; dp[i][j][l] += dp[i-1][j-1][l+2]; }
                    if j < n-2 && l > 0 { cnt += 1; dp[i][j][l] += dp[i-1][j+2][l-1]; }
                    if j < n-2 && l < n-1 { cnt += 1; dp[i][j][l] += dp[i-1][j+2][l+1]; }
                    if j < n-1 && l > 1 { cnt += 1; dp[i][j][l] += dp[i-1][j+1][l-2]; }
                    if j < n-1 && l < n-2 { cnt += 1; dp[i][j][l] += dp[i-1][j+1][l+2]; }
                    dp[i][j][l] /= cnt as f64;
                }
            }
        }
        dp[k][row][column]
    }
}