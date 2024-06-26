impl Solution {
    pub fn num_distinct(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let (m, n) = (s.len(), t.len());
        let mut dp = vec![vec![0; n + 1]; m + 1];
        for i in 0..=m {
            dp[i][0] = 1;
        }
        for i in 1..=m {
            for j in 1..=n {
                dp[i][j] = dp[i - 1][j];
                if s[i - 1] == t[j - 1] {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        dp[m][n]
    }
}