impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut dp = vec![vec![0; s.len()]; s.len()];
        for i in 0..s.len() {
            dp[i][i] = 0;
            if i + 1 < s.len() {
                dp[i][i + 1] = if s.as_bytes()[i] == s.as_bytes()[i + 1] { 0 } else { 1 };
            }
        }
        for i in (0..s.len()).rev() {
            for j in (i + 2)..s.len() {
                dp[i][j] = if s.as_bytes()[i] == s.as_bytes()[j] {
                    dp[i + 1][j - 1]
                } else {
                    1 + std::cmp::min(dp[i + 1][j], dp[i][j - 1])
                }
            }
        }
        dp[0][s.len() - 1] as i32
    }
}