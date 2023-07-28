impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let mut dp = vec![vec![0; s.len()]; s.len()];
        for i in (0..s.len()).rev() {
            for j in i+1..s.len() {
                if s[i] == s[j] {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = 1 + dp[i+1][j].min(dp[i][j-1]);
                }
            }
        }
        dp[0][s.len()-1] as i32
    }
}