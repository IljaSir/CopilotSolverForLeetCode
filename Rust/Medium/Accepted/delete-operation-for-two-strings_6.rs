impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        

        let (w1, w2) = (word1.as_bytes(), word2.as_bytes());
        let (n, m) = (w1.len(), w2.len());
        let mut dp = vec![vec![0; m + 1]; n + 1];
        for i in 0..=n {
            dp[i][0] = i as i32;
        }
        for j in 0..=m {
            dp[0][j] = j as i32;
        }
        for i in 1..=n {
            for j in 1..=m {
                dp[i][j] = dp[i - 1][j - 1] + if w1[i - 1] == w2[j - 1] { 0 } else { 2 };
                dp[i][j] = dp[i][j].min(dp[i - 1][j] + 1);
                dp[i][j] = dp[i][j].min(dp[i][j - 1] + 1);
            }
        }
        dp[n][m]
    }
}