impl Solution {
    pub fn maximum_subsequence_count(text: String, pattern: String) -> i64 {
        
        let mut dp = vec![vec![0; pattern.len() + 1]; text.len() + 1];
        let text: Vec<char> = text.chars().collect();
        let pattern: Vec<char> = pattern.chars().collect();
        for i in 0..text.len() {
            for j in 0..pattern.len() {
                if text[i] == pattern[j] {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        let mut ans = 0;
        for i in 0..text.len() {
            if text[i] == pattern[0] || text[i] == pattern[1] {
                ans += dp[i][pattern.len()];
            }
        }
        ans
    }
}