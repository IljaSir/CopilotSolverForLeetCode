impl Solution {
    pub fn knight_dialer(n: i32) -> i32 {
        
        let mut dp = vec![vec![0; 10]; n as usize];
        let mut sum = 0;
        for i in 0..10 {
            dp[0][i] = 1;
        }
        for i in 1..n as usize {
            dp[i][0] = (dp[i-1][4] + dp[i-1][6]) % 1000000007;
            dp[i][1] = (dp[i-1][6] + dp[i-1][8]) % 1000000007;
            dp[i][2] = (dp[i-1][7] + dp[i-1][9]) % 1000000007;
            dp[i][3] = (dp[i-1][4] + dp[i-1][8]) % 1000000007;
            dp[i][4] = ((dp[i-1][3] + dp[i-1][9]) % 1000000007 + dp[i-1][0]) % 1000000007;
            dp[i][5] = 0;
            dp[i][6] = ((dp[i-1][1] + dp[i-1][7]) % 1000000007 + dp[i-1][0]) % 1000000007;
            dp[i][7] = (dp[i-1][2] + dp[i-1][6]) % 1000000007;
            dp[i][8] = (dp[i-1][1] + dp[i-1][3]) % 1000000007;
            dp[i][9] = (dp[i-1][2] + dp[i-1][4]) % 1000000007;
        }
        for i in 0..10 {
            sum = (sum + dp[n as usize - 1][i]) % 1000000007;
        }
        sum
    }
}