impl Solution {
    pub fn longest_palindrome(word1: String, word2: String) -> i32 {
        
        let mut dp = vec![vec![0; 2001]; 2001];
        let mut s = word1 + &word2;
        let n = s.len();
        for i in 0..n {
            for j in (0..i).rev() {
                dp[j][i] = if s.chars().nth(i) == s.chars().nth(j) {
                    dp[j + 1][i - 1] + 2
                } else {
                    dp[j + 1][i].max(dp[j][i - 1])
                };
            }
        }
        dp[0][n - 1]
    }
}