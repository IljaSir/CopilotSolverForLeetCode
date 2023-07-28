impl Solution {
    pub fn check_partitioning(s: String) -> bool {
        
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            dp[i][i] = true;
            if i < n - 1 {
                dp[i][i + 1] = s.chars().nth(i) == s.chars().nth(i + 1);
            }
        }
        for l in 2..n {
            for i in 0..(n - l) {
                let j = i + l;
                dp[i][j] = dp[i + 1][j - 1] && s.chars().nth(i) == s.chars().nth(j);
            }
        }
        for i in 0..(n - 2) {
            for j in (i + 1)..(n - 1) {
                if dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1] {
                    return true;
                }
            }
        }
        false
    }
}