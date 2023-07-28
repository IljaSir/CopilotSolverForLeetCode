impl Solution {
    pub fn min_distance(word1: String, word2: String) -> i32 {
        

        let (word1, word2) = (word1.as_bytes(), word2.as_bytes());
        let (n1, n2) = (word1.len(), word2.len());
        let mut dp = vec![vec![0; n2 + 1]; n1 + 1];
        for i in 0..=n1 {
            for j in 0..=n2 {
                dp[i][j] = if i == 0 || j == 0 {
                    i + j
                } else if word1[i-1] == word2[j-1] {
                    dp[i-1][j-1]
                } else {
                    1 + dp[i-1][j].min(dp[i][j-1])
                }
            }
        }
        dp[n1][n2] as i32
    }
}