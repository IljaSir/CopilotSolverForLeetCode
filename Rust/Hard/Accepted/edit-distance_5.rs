impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        
        let (word1, word2) = (word1.as_bytes(), word2.as_bytes());
        let (n, m) = (word1.len(), word2.len());
        let mut dp = vec![vec![0; m + 1]; n + 1];
        for i in 1..=n {
            dp[i][0] = i as i32;
        }
        for j in 1..=m {
            dp[0][j] = j as i32;
        }
        for i in 1..=n {
            for j in 1..=m {
                dp[i][j] = dp[i - 1][j - 1] + if word1[i - 1] != word2[j - 1] { 1 } else { 0 };
                dp[i][j] = dp[i][j].min(dp[i - 1][j] + 1);
                dp[i][j] = dp[i][j].min(dp[i][j - 1] + 1);
            }
        }
        dp[n][m]
    }
}