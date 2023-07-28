impl Solution {
    pub fn maximum_subsequence_count(text: String, pattern: String) -> i64 {
        
        let mut dp = vec![vec![0; 3]; text.len() + 1];
        let mut i = 1;
        for c in text.chars() {
            dp[i][0] = dp[i - 1][0] + (c == pattern.chars().nth(0).unwrap()) as i64;
            dp[i][1] = dp[i - 1][1] + (c == pattern.chars().nth(1).unwrap()) as i64;
            dp[i][2] = dp[i - 1][2] + (c == pattern.chars().nth(0).unwrap()) as i64;
            dp[i][2] = dp[i][2].max(dp[i - 1][1] + (c == pattern.chars().nth(1).unwrap()) as i64);
            i += 1;
        }
        dp[text.len()][2]
    }
}