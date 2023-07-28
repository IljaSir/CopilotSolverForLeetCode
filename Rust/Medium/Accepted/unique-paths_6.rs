impl Solution {
    pub fn unique_paths(m: i32, n: i32) -> i32 {
        

        let mut dp = vec![vec![0; n as usize]; m as usize];
        for i in 0..m {
            for j in 0..n {
                if i == 0 && j == 0 {
                    dp[i as usize][j as usize] = 1;
                } else if i == 0 {
                    dp[i as usize][j as usize] = dp[i as usize][j as usize - 1];
                } else if j == 0 {
                    dp[i as usize][j as usize] = dp[i as usize - 1][j as usize];
                } else {
                    dp[i as usize][j as usize] = dp[i as usize - 1][j as usize] + dp[i as usize][j as usize - 1];
                }
            }
        }
        dp[m as usize - 1][n as usize - 1]
    }
}