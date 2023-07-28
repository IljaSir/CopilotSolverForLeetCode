impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut dp = vec![vec![0; t.len() + 1]; s.len() + 1];
        for i in 1..=s.len() {
            for j in 1..=t.len() {
                if s[i - 1] == t[j - 1] {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j].max(dp[i][j - 1]);
                }
            }
        }
        let mut i = s.len();
        let mut j = t.len();
        let mut ans = 0;
        while i > 0 && j > 0 {
            if s[i - 1] == t[j - 1] {
                if dp[i][j] == dp[i - 1][j - 1] + 1 {
                    ans += 1;
                    i -= 1;
                    j -= 1;
                } else {
                    break;
                }
            } else {
                if dp[i][j] == dp[i - 1][j] {
                    i -= 1;
                } else {
                    j -= 1;
                }
            }
        }
        ans as i32
    }
}