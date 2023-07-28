impl Solution {
    pub fn num_distinct(s: String, t: String) -> i32 {
        
        let (s, t) = (s.as_bytes(), t.as_bytes());
        let (n, m) = (s.len(), t.len());
        let mut dp = vec![vec![0; m + 1]; n + 1];
        for i in 0..=n {
            dp[i][m] = 1;
        }
        for i in (0..n).rev() {
            for j in (0..m).rev() {
                if s[i] == t[j] {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        dp[0][0]
    }
}