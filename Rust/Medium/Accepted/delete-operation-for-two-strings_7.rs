impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        

        let (word1, word2) = (word1.as_bytes(), word2.as_bytes());
        let mut dp = vec![vec![0; word2.len() + 1]; word1.len() + 1];
        for i in 0..=word1.len() {
            for j in 0..=word2.len() {
                if i == 0 || j == 0 {
                    dp[i][j] = i + j;
                } else if word1[i - 1] == word2[j - 1] {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + std::cmp::min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        dp[word1.len()][word2.len()] as i32
    }
}