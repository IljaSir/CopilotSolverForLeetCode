impl Solution {
    pub fn max_product(s: String) -> i32 {
        
        let n = s.len();
        let s = s.into_bytes();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            dp[i][i] = true;
        }
        for i in (0..n).rev() {
            for j in i+1..n {
                if s[i] == s[j] {
                    dp[i][j] = j - i == 1 || dp[i+1][j-1];
                }
            }
        }
        let mut ans = 0;
        for i in 0..n {
            for j in i+1..n {
                if dp[0][i] && dp[i+1][j-1] && dp[j][n-1] {
                    ans = ans.max((i+1) * (n - j));
                }
                if dp[0][j] && dp[j+1][i-1] && dp[i][n-1] {
                    ans = ans.max((j+1) * (n - i));
                }
            }
        }
        ans as i32
    }
}