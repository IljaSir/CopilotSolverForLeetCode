impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        

        let (n, m) = (word1.len(), word2.len());
        let mut dp = vec![vec![0; m + 1]; n + 1];
        for i in 0..=n {
            for j in 0..=m {
                if i == 0 || j == 0 {
                    dp[i][j] = i + j;
                } else {
                    dp[i][j] = if word1.as_bytes()[i - 1] == word2.as_bytes()[j - 1] {
                        dp[i - 1][j - 1]
                    } else {
                        dp[i - 1][j - 1] + 1
                    };
                }
                dp[i][j] = dp[i][j].min(dp[i - 1][j] + 1);
                dp[i][j] = dp[i][j].min(dp[i][j - 1] + 1);
            }
        }
        dp[n][m] as i32
    }
}