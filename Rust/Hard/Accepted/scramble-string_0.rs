impl Solution {
    pub fn is_scramble(s1: String, s2: String) -> bool {
        
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let n = s1.len();
        let mut dp = vec![vec![vec![false; n + 1]; n]; n];
        for i in 0..n {
            for j in 0..n {
                dp[i][j][1] = s1[i] == s2[j];
            }
        }
        for len in 2..=n {
            for i in 0..=n - len {
                for j in 0..=n - len {
                    for k in 1..len {
                        if (dp[i][j][k] && dp[i + k][j + k][len - k])
                            || (dp[i][j + len - k][k] && dp[i + k][j][len - k])
                        {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        dp[0][0][n]
    }
}