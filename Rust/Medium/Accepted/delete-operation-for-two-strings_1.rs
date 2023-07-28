impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        

        let word1: Vec<char> = word1.chars().collect();
        let word2: Vec<char> = word2.chars().collect();
        let mut dp = vec![vec![0; word2.len() + 1]; word1.len() + 1];
        for i in 1..=word1.len() {
            for j in 1..=word2.len() {
                if word1[i - 1] == word2[j - 1] {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j].max(dp[i][j - 1]);
                }
            }
        }
        let lcs = dp[word1.len()][word2.len()];
        (word1.len() - lcs) as i32 + (word2.len() - lcs) as i32
    }
}