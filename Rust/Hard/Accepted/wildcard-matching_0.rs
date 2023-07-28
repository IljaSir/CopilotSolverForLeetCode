impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        
        let s = s.as_bytes();
        let p = p.as_bytes();
        let mut dp = vec![vec![false; p.len() + 1]; s.len() + 1];
        dp[0][0] = true;
        for i in 1..=p.len() {
            if p[i - 1] != b'*' {
                break;
            }
            dp[0][i] = true;
        }
        for i in 1..=s.len() {
            for j in 1..=p.len() {
                if p[j - 1] == b'*' {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == b'?');
                }
            }
        }
        dp[s.len()][p.len()]
    }
}