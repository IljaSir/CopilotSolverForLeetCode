impl Solution {
    pub fn knight_dialer(n: i32) -> i32 {
        
        let mut dp = vec![vec![0; 10]; n as usize + 1];
        for i in 0..10 {
            dp[1][i] = 1;
        }
        let dirs = vec![(1, 2), (-1, 2), (1, -2), (-1, -2), (2, 1), (-2, 1), (2, -1), (-2, -1)];
        let mod_num = 1000000007;
        for i in 2..=n {
            for j in 0..10 {
                for dir in &dirs {
                    let x = j as i32 + dir.0;
                    let y = j as i32 + dir.1;
                    if (x >= 0 && x < 10) && (y >= 0 && y < 10) && (x != 3 || y != 3) && (x != 3 || y != 1) && (x != 3 || y != 2) {
                        dp[i as usize][j as usize] = (dp[i as usize][j as usize] + dp[(i - 1) as usize][x as usize]) % mod_num;
                        dp[i as usize][j as usize] = (dp[i as usize][j as usize] + dp[(i - 1) as usize][y as usize]) % mod_num;
                    }
                }
            }
        }
        let mut res = 0;
        for i in 0..10 {
            res = (res + dp[n as usize][i]) % mod_num;
        }
        res
    }
}