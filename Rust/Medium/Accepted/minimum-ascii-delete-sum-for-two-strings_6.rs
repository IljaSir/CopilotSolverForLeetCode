impl Solution {
    pub fn minimum_delete_sum(s1: String, s2: String) -> i32 {
        

        let (s1, s2) = (s1.as_bytes(), s2.as_bytes());
        let (n, m) = (s1.len(), s2.len());
        let mut dp = vec![vec![0; m + 1]; n + 1];
        for i in 1..=n {
            dp[i][0] = dp[i - 1][0] + s1[i - 1] as i32;
        }
        for j in 1..=m {
            dp[0][j] = dp[0][j - 1] + s2[j - 1] as i32;
        }
        for i in 1..=n {
            for j in 1..=m {
                if s1[i - 1] == s2[j - 1] {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + s1[i - 1] as i32 + s2[j - 1] as i32;
                }
                dp[i][j] = dp[i][j].min(dp[i - 1][j] + s1[i - 1] as i32);
                dp[i][j] = dp[i][j].min(dp[i][j - 1] + s2[j - 1] as i32);
            }
        }
        dp[n][m]
    }
}