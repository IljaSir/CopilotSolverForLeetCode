impl Solution {
    pub fn check_record(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![vec![0; 3]; 2]; n + 1];
        dp[0][0][0] = 1;
        for i in 0..n {
            for j in 0..2 {
                for k in 0..3 {
                    dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][k]) % 1000000007;
                    if k < 2 {
                        dp[i + 1][j][k + 1] = (dp[i + 1][j][k + 1] + dp[i][j][k]) % 1000000007;
                    }
                    if j < 1 {
                        dp[i + 1][j + 1][0] = (dp[i + 1][j + 1][0] + dp[i][j][k]) % 1000000007;
                    }
                }
            }
        }
        let mut res = 0;
        for j in 0..2 {
            for k in 0..3 {
                res = (res + dp[n][j][k]) % 1000000007;
            }
        }
        res
    }
}