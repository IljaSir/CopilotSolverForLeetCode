impl Solution {
    pub fn knight_probability(n: i32, k: i32, row: i32, column: i32) -> f64 {
        

        let n = n as usize;
        let k = k as usize;
        let row = row as usize;
        let column = column as usize;
        let mut dp = vec![vec![vec![0.0; n]; n]; k + 1];
        let mut ans = 0.0;
        let mut next = vec![vec![0.0; n]; n];
        for i in 0..n {
            for j in 0..n {
                dp[0][i][j] = 1.0;
            }
        }
        let mut dirs = vec![(2, 1), (2, -1), (-2, 1), (-2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)];
        for i in 1..=k {
            for j in 0..n {
                for l in 0..n {
                    for dir in dirs.iter() {
                        let x = j as i32 + dir.0;
                        let y = l as i32 + dir.1;
                        if x >= 0 && x < n as i32 && y >= 0 && y < n as i32 {
                            let x = x as usize;
                            let y = y as usize;
                            next[j][l] += dp[i - 1][x][y];
                        }
                    }
                }
            }
            dp[i] = next.clone();
            for j in 0..n {
                for l in 0..n {
                    next[j][l] = 0.0;
                }
            }
        }
        for i in 0..n {
            for j in 0..n {
                ans += dp[k][i][j];
            }
        }
        ans / 8.0f64.powi(k as i32)
    }
}