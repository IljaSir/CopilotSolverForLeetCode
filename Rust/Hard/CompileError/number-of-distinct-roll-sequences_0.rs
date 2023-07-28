impl Solution {
    pub fn distinct_sequences(n: i32) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![vec![vec![0; 7]; 7]; n + 1];
        for i in 1..=6 {
            dp[1][i][i] = 1;
        }
        for i in 2..=n {
            for j in 1..=6 {
                for k in 1..=6 {
                    for l in 1..=6 {
                        if j != k && k != l && gcd(j, k) == 1 && gcd(k, l) == 1 {
                            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][k][l]) % 1000000007;
                        }
                    }
                }
            }
        }
        let mut res = 0;
        for i in 1..=6 {
            for j in 1..=6 {
                res = (res + dp[n][i][j]) % 1000000007;
            }
        }
        res
    }
}