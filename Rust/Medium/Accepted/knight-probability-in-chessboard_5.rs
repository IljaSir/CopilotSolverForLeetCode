impl Solution {
    pub fn knight_probability(n: i32, k: i32, row: i32, column: i32) -> f64 {
        

        let n = n as usize;
        let k = k as usize;
        let row = row as usize;
        let column = column as usize;
        let mut dp = vec![vec![vec![0.0; k+1]; n]; n];
        for t in 0..k+1 {
            for i in 0..n {
                for j in 0..n {
                    dp[i][j][t] = if t == k { 1.0 } else { 0.0 };
                }
            }
        }
        for t in (0..k).rev() {
            for i in 0..n {
                for j in 0..n {
                    let mut sum = 0.0;
                    for (dx, dy) in vec![(2, 1), (2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2), (-2, 1), (-2, -1)] {
                        let x = i as i32 + dx;
                        let y = j as i32 + dy;
                        if x >= 0 && x < n as i32 && y >= 0 && y < n as i32 {
                            sum += dp[x as usize][y as usize][t+1];
                        }
                    }
                    dp[i][j][t] = sum / 8.0;
                }
            }
        }
        dp[row][column][0]
    }
}