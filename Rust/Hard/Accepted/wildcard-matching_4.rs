impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let p: Vec<char> = p.chars().collect();
        let mut dp = vec![vec![false; s.len() + 1]; p.len() + 1];
        dp[0][0] = true;
        for i in 1..=p.len() {
            if p[i - 1] == '*' {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for i in 1..=p.len() {
            for j in 1..=s.len() {
                if p[i - 1] == '?' || p[i - 1] == s[j - 1] {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if p[i - 1] == '*' {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        dp[p.len()][s.len()]
    }
}