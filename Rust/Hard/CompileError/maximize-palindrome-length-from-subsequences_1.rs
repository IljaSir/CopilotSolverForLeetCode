impl Solution {
    pub fn longest_palindrome(word1: String, word2: String) -> i32 {
        
        let word1 = word1.as_bytes();
        let word2 = word2.as_bytes();
        let n1 = word1.len();
        let n2 = word2.len();
        let mut dp = vec![vec![0; n2 + 1]; n1 + 1];
        for i in 1..=n1 {
            for j in 1..=n2 {
                if word1[i - 1] == word2[j - 1] {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j].max(dp[i][j - 1]);
                }
            }
        }
        let mut ans = 0;
        let mut i = n1;
        let mut j = n2;
        while i > 0 && j > 0 {
            if word1[i - 1] == word2[j - 1] {
                ans += 1;
                i -= 1;
                j -= 1;
            } else if dp[i - 1][j] > dp[i][j - 1] {
                i -= 1;
            } else {
                j -= 1;
            }
        }
        ans * 2 + (n1 + n2 - ans * 2) as i32
    }
}