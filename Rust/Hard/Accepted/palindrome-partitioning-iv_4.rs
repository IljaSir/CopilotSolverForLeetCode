impl Solution {
    pub fn check_partitioning(s: String) -> bool {
        
        let n = s.len();
        let s = s.as_bytes();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            dp[i][i] = true;
        }
        for i in (0..n).rev() {
            for j in i+1..n {
                dp[i][j] = s[i] == s[j] && (i+1 == j || dp[i+1][j-1]);
            }
        }
        for i in 0..n-2 {
            for j in i+1..n-1 {
                if dp[0][i] && dp[i+1][j] && dp[j+1][n-1] {
                    return true;
                }
            }
        }
        false
    }
}