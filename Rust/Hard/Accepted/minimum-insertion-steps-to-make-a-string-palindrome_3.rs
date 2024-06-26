impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![0; n]; n];
        for i in (0..n-1).rev() {
            for j in i+1..n {
                if s[i] == s[j] {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = 1 + dp[i+1][j].min(dp[i][j-1]);
                }
            }
        }
        dp[0][n-1] as i32
    }
}