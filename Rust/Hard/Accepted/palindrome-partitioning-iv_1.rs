impl Solution {
    pub fn check_partitioning(s: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            dp[i][i] = true;
            if i < n - 1 {
                dp[i][i+1] = s[i] == s[i+1];
            }
        }
        for l in 2..n {
            for i in 0..n-l {
                dp[i][i+l] = dp[i+1][i+l-1] && s[i] == s[i+l];
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