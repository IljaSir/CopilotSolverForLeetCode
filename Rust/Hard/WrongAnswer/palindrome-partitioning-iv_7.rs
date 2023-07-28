impl Solution {
    pub fn check_partitioning(s: String) -> bool {
        
        let s = s.into_bytes();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            dp[i][i] = true;
            if i+1 < n && s[i] == s[i+1] {
                dp[i][i+1] = true;
            }
        }
        for l in 3..=n {
            for i in 0..=n-l {
                let j = i+l-1;
                dp[i][j] = s[i] == s[j] && dp[i+1][j-1];
            }
        }
        for i in 1..n-1 {
            for j in i+1..n-1 {
                if dp[0][i-1] && dp[i][j] && dp[j+1][n-1] {
                    return true;
                }
            }
        }
        false
    }
}