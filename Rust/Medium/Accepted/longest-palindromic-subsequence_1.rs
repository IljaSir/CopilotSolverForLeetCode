impl Solution {
    pub fn longest_palindrome_subseq(s: String) -> i32 {
        

        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![vec![0; n]; n];
        for i in (0..n).rev() {
            dp[i][i] = 1;
            for j in i+1..n {
                if s[i] == s[j] {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = dp[i+1][j].max(dp[i][j-1]);
                }
            }
        }
        dp[0][n-1]
    }
}