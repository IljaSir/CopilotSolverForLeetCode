impl Solution {
    pub fn k_inverse_pairs(n: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let k = k as usize;
        let mut dp = vec![vec![0; k+1]; n+1];
        for i in 1..=n {
            dp[i][0] = 1;
        }
        for i in 2..=n {
            for j in 1..=k {
                let mut sum = dp[i-1][j];
                if j >= i {
                    sum += dp[i-1][j-i];
                }
                dp[i][j] = (sum + dp[i][j-1]) % 1000000007;
            }
        }
        dp[n][k] as i32
    }
}