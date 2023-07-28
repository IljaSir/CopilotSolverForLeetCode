impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![vec![0; n]; n];
        for l in 2..=n {
            for i in 0..=n - l {
                let j = i + l - 1;
                if s[i] == s[j] {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + dp[i + 1][j].min(dp[i][j - 1]);
                }
            }
        }
        dp[0][n - 1] as i32
    }
}