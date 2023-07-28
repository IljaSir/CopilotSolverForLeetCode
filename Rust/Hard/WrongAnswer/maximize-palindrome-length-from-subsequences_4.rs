impl Solution {
    pub fn longest_palindrome(word1: String, word2: String) -> i32 {
        
        let word = format!("{}{}", word1, word2);
        let n = word.len();
        let word = word.as_bytes();
        
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 1;
        }
        for i in (0..n).rev() {
            for j in i+1..n {
                if word[i] == word[j] {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = std::cmp::max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        dp[0][n-1]
    }
}