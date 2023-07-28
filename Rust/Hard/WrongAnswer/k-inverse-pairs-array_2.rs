impl Solution {
    pub fn k_inverse_pairs(n: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let k = k as usize;
        let mut dp = vec![vec![0; k + 1]; n + 1];
        let modu = 1000000007;
        for i in 1..=n {
            dp[i][0] = 1;
        }
        for i in 1..=n {
            for j in 1..=k {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % modu;
                if j >= i {
                    dp[i][j] = (dp[i][j] + modu - dp[i - 1][j - i]) % modu;
                }
            }
        }
        dp[n][k]
    }
}