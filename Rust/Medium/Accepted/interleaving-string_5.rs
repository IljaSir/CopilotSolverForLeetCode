impl Solution {
    pub fn is_interleave(s1: String, s2: String, s3: String) -> bool {
        

        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let s3 = s3.as_bytes();
        let (m, n) = (s1.len(), s2.len());
        if m + n != s3.len() {
            return false;
        }
        let mut dp = vec![vec![false; n + 1]; m + 1];
        dp[0][0] = true;
        for i in 0..m {
            dp[i + 1][0] = dp[i][0] && s1[i] == s3[i];
        }
        for j in 0..n {
            dp[0][j + 1] = dp[0][j] && s2[j] == s3[j];
        }
        for i in 0..m {
            for j in 0..n {
                dp[i + 1][j + 1] = (dp[i][j + 1] && s1[i] == s3[i + j + 1])
                    || (dp[i + 1][j] && s2[j] == s3[i + j + 1]);
            }
        }
        dp[m][n]
    }
}