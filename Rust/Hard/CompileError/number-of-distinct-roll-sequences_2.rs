impl Solution {
    pub fn distinct_sequences(n: i32) -> i32 {
        
        let mut dp = vec![vec![0; 7]; n as usize + 1];
        let modu = 1000000007;
        for i in 1..=6 {
            dp[1][i] = 1;
        }
        for i in 2..=n as usize {
            for j in 1..=6 {
                for k in 1..=6 {
                    if j == k {
                        continue;
                    }
                    if j.gcd(k) == 1 {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= modu;
                    }
                }
            }
        }
        let mut ans = 0;
        for i in 1..=6 {
            ans += dp[n as usize][i];
            ans %= modu;
        }
        ans
    }
}