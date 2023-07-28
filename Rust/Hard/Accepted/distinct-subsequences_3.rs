impl Solution {
    pub fn num_distinct(s: String, t: String) -> i32 {
        
        let (s, t) = (s.as_bytes(), t.as_bytes());
        let mut dp = vec![vec![0; t.len() + 1]; s.len() + 1];
        for i in 0..=s.len() {
            dp[i][0] = 1;
        }
        for i in 1..=s.len() {
            for j in 1..=t.len() {
                if s[i - 1] == t[j - 1] {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        dp[s.len()][t.len()]
    }
}