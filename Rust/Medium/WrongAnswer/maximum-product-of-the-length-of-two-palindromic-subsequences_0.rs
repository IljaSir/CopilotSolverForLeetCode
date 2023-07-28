impl Solution {
    pub fn max_product(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 1;
        }
        for i in (0..n).rev() {
            for j in i+1..n {
                dp[i][j] = if s[i] == s[j] { dp[i+1][j-1] + 2 } else { dp[i+1][j].max(dp[i][j-1]) };
            }
        }
        let mut res = 0;
        for i in 0..n {
            for j in i+1..n {
                if dp[0][i] == i+1 && dp[i+1][j] == j-i && dp[j+1][n-1] == n-j-1 {
                    res = res.max((i+1) * (n-j-1));
                }
                if dp[0][i] == i+1 && dp[i+1][j] == j-i && dp[j+1][n-1] == n-j-1 {
                    res = res.max((i+1) * (n-j-1));
                }
            }
        }
        res as i32
    }
}