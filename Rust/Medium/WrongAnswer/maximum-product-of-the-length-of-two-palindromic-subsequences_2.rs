impl Solution {
    pub fn max_product(s: String) -> i32 {
        
        let n = s.len();
        let s: Vec<char> = s.chars().collect();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 1;
        }
        for i in (0..n).rev() {
            for j in i+1..n {
                if s[i] == s[j] {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = dp[i+1][j].max(dp[i][j-1]);
                }
            }
        }
        let mut res = 0;
        for i in 0..n-1 {
            for j in i+1..n {
                if dp[0][i] == dp[i+1][j] && dp[i+1][j] == dp[j+1][n-1] {
                    res = res.max(dp[0][i] * dp[j+1][n-1]);
                }
            }
        }
        res as i32
    }
}