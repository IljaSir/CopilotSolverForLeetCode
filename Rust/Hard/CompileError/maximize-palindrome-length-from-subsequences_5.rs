impl Solution {
    pub fn longest_palindrome(word1: String, word2: String) -> i32 {
        
        let mut dp = vec![vec![0; word1.len() + word2.len()]; word1.len() + word2.len()];
        let mut res = 0;
        let mut s = word1 + &word2;
        for i in (0..s.len()).rev() {
            dp[i][i] = 1;
            for j in i+1..s.len() {
                if s[i] == s[j] {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = std::cmp::max(dp[i+1][j], dp[i][j-1]);
                }
                if i < word1.len() && j >= word1.len() {
                    res = std::cmp::max(res, dp[i][j]);
                }
            }
        }
        res
    }
}