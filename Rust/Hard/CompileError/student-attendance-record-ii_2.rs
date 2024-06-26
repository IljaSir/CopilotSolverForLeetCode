impl Solution {
    pub fn check_record(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![vec![0; 3]; 2]; n+1];
        dp[0][0][0] = 1;
        for i in 1..n+1 {
            for j in 0..2 {
                for k in 0..3 {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % 1000000007;
                    if j > 0 {
                        dp[i][j][0] = (dp[i][j][0] + dp[i-1][j-1][k]) % 1000000007;
                    }
                    if k > 0 {
                        dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % 1000000007;
                    }
                }
            }
        }
        let mut sum = 0;
        for j in 0..2 {
            for k in 0..3 {
                sum = (sum + dp[n][j][k]) % 1000000007;
            }
        }
        sum
    }
}