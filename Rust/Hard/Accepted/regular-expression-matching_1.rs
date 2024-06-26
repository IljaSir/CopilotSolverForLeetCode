impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let p: Vec<char> = p.chars().collect();
        let mut dp = vec![vec![false; p.len() + 1]; s.len() + 1];
        dp[0][0] = true;
        for i in 0..=s.len() {
            for j in 1..=p.len() {
                if p[j - 1] == '*' {
                    dp[i][j] = dp[i][j - 2] || i > 0 && dp[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.');
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
                }
            }
        }
        dp[s.len()][p.len()]
    }
}