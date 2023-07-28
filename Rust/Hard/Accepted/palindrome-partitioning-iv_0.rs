impl Solution {
    pub fn check_partitioning(s: String) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            dp[i][i] = true;
            if i > 0 && s[i] == s[i - 1] {
                dp[i - 1][i] = true;
            }
        }
        for len in 3..=n {
            for l in 0..=n - len {
                let r = l + len - 1;
                dp[l][r] = dp[l + 1][r - 1] && s[l] == s[r];
            }
        }
        for i in 1..n - 1 {
            for j in i + 1..n {
                if dp[0][i - 1] && dp[i][j - 1] && dp[j][n - 1] {
                    return true;
                }
            }
        }
        false
    }
}