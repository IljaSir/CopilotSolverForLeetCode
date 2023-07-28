impl Solution {
    pub fn knight_probability(n: i32, k: i32, row: i32, column: i32) -> f64 {
        

        let mut dp = vec![vec![vec![0.0; n as usize]; n as usize]; k as usize + 1];
        let mut dp_next = vec![vec![vec![0.0; n as usize]; n as usize]; k as usize + 1];
        let mut res = 0.0;
        dp[0][row as usize][column as usize] = 1.0;
        for i in 0..k {
            for j in 0..n {
                for m in 0..n {
                    if dp[i as usize][j as usize][m as usize] == 0.0 {
                        continue;
                    }
                    let mut count = 0;
                    if j > 1 && m > 0 {
                        count += 1;
                        dp_next[(i + 1) as usize][j as usize - 2][m as usize - 1] += dp[i as usize][j as usize][m as usize] / 8.0;
                    }
                    if j > 1 && m < n - 1 {
                        count += 1;
                        dp_next[(i + 1) as usize][j as usize - 2][m as usize + 1] += dp[i as usize][j as usize][m as usize] / 8.0;
                    }
                    if j > 0 && m > 1 {
                        count += 1;
                        dp_next[(i + 1) as usize][j as usize - 1][m as usize - 2] += dp[i as usize][j as usize][m as usize] / 8.0;
                    }
                    if j > 0 && m < n - 2 {
                        count += 1;
                        dp_next[(i + 1) as usize][j as usize - 1][m as usize + 2] += dp[i as usize][j as usize][m as usize] / 8.0;
                    }
                    if j < n - 1 && m > 1 {
                        count += 1;
                        dp_next[(i + 1) as usize][j as usize + 1][m as usize - 2] += dp[i as usize][j as usize][m as usize] / 8.0;
                    }
                    if j < n - 1 && m < n
    }
}