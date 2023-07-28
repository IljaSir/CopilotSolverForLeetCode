impl Solution {
    pub fn longest_palindrome(word1: String, word2: String) -> i32 {
        
        let s = word1 + &word2;
        let n = s.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 1;
        }
        for l in 2..=n {
            for i in 0..=n - l {
                let j = i + l - 1;
                if s[i..=i] == s[j..=j] {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = dp[i][j - 1].max(dp[i + 1][j]);
                }
            }
        }
        let mut res = 0;
        for i in 0..word1.len() {
            for j in word1.len()..n {
                if s[i..=i] == s[j..=j] {
                    res = res.max(dp[0][i - 1] + dp[i + 1][j - 1] + dp[j + 1][n - 1] + 2);
                }
            }
        }
        res
    }
}