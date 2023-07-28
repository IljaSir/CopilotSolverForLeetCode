impl Solution {
    pub fn num_distinct(s: String, t: String) -> i32 {
        
        let s = s.into_bytes();
        let t = t.into_bytes();
        let n = s.len();
        let m = t.len();
        let mut dp = vec![vec![0; n + 1]; m + 1];
        for i in 0..=n {
            dp[0][i] = 1;
        }
        for i in 1..=m {
            for j in 1..=n {
                if s[j - 1] == t[i - 1] {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        dp[m][n]
    }
}