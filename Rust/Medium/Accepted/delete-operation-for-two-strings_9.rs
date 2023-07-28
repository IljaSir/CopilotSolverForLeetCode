impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        

        let (word1, word2) = (word1.chars().collect::<Vec<_>>(), word2.chars().collect::<Vec<_>>());
        let (n, m) = (word1.len(), word2.len());
        let mut dp = vec![vec![0; m + 1]; n + 1];
        for i in 0..=n {
            for j in 0..=m {
                if i == 0 || j == 0 {
                    dp[i][j] = i + j;
                } else if word1[i - 1] == word2[j - 1] {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + dp[i - 1][j].min(dp[i][j - 1]);
                }
            }
        }
        dp[n][m] as i32
    }
}