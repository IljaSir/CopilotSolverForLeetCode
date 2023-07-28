impl Solution {
    pub fn check_partitioning(s: String) -> bool {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            dp[i][i] = true;
        }
        for i in 0..n-1 {
            dp[i][i+1] = s[i] == s[i+1];
        }
        for i in 0..n-2 {
            dp[i][i+2] = s[i] == s[i+2];
        }
        for i in (0..n).rev() {
            for j in i+3..n {
                dp[i][j] = s[i] == s[j] && dp[i+1][j-1];
            }
        }
        for i in 0..n-2 {
            if dp[0][i] {
                for j in i+1..n-1 {
                    if dp[i+1][j] && dp[j+1][n-1] {
                        return true;
                    }
                }
            }
        }
        false
    }
}