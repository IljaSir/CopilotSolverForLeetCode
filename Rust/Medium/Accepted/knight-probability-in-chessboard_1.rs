impl Solution {
    pub fn knight_probability(n: i32, k: i32, row: i32, column: i32) -> f64 {
        

        let n = n as usize;
        let k = k as usize;
        let row = row as usize;
        let column = column as usize;
        let mut dp = vec![vec![vec![0.0; n]; n]; k + 1];
        for i in 0..n {
            for j in 0..n {
                dp[0][i][j] = 1.0;
            }
        }
        for step in 1..=k {
            for i in 0..n {
                for j in 0..n {
                    let mut prob = 0.0;
                    if i >= 2 {
                        if j >= 1 {
                            prob += dp[step - 1][i - 2][j - 1];
                        }
                        if j < n - 1 {
                            prob += dp[step - 1][i - 2][j + 1];
                        }
                    }
                    if i >= 1 {
                        if j >= 2 {
                            prob += dp[step - 1][i - 1][j - 2];
                        }
                        if j < n - 2 {
                            prob += dp[step - 1][i - 1][j + 2];
                        }
                    }
                    if i < n - 2 {
                        if j >= 1 {
                            prob += dp[step - 1][i + 2][j - 1];
                        }
                        if j < n - 1 {
                            prob += dp[step - 1][i + 2][j + 1];
                        }
                    }
                    if i < n - 1 {
                        if j >= 2 {
                            prob += dp[step - 1][i + 1][j - 2];
                        }
                        if j < n - 2 {
                            prob += dp[step - 1][i + 1][j + 2];
                        }
                    }
                    dp[step][i][j] = prob / 8.0;
                }
            }
        }
        dp[k][row][column]
    }
}