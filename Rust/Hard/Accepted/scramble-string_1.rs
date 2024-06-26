impl Solution {
    pub fn is_scramble(s1: String, s2: String) -> bool {
        
        let s1: Vec<char> = s1.chars().collect();
        let s2: Vec<char> = s2.chars().collect();
        let n = s1.len();
        let mut dp = vec![vec![vec![false; n + 1]; n]; n];
        for i in 0..n {
            for j in 0..n {
                dp[i][j][1] = s1[i] == s2[j];
            }
        }
        for l in 2..=n {
            for i in 0..=n - l {
                for j in 0..=n - l {
                    for k in 1..l {
                        if dp[i][j][k] && dp[i + k][j + k][l - k] || dp[i][j + l - k][k] && dp[i + k][j][l - k] {
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        dp[0][0][n]
    }
}