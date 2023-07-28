impl Solution {
    pub fn longest_palindrome(word1: String, word2: String) -> i32 {
        
        let mut dp = vec![vec![0; word1.len() + word2.len()]; word1.len() + word2.len()];
        let mut ans = 0;
        let mut word = word1 + &word2;
        for i in (0..word1.len() + word2.len()).rev() {
            for j in i + 1..word1.len() + word2.len() {
                if word.chars().nth(i).unwrap() == word.chars().nth(j).unwrap() {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                ans = ans.max(dp[i][j]);
            }
        }
        ans
    }
}