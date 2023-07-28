impl Solution {
    pub fn is_interleave(s1: String, s2: String, s3: String) -> bool {
        

        let (s1, s2, s3) = (s1.as_bytes(), s2.as_bytes(), s3.as_bytes());
        let (m, n) = (s1.len(), s2.len());
        if m + n != s3.len() {
            return false;
        }
        let mut dp = vec![vec![false; n + 1]; m + 1];
        dp[0][0] = true;
        for i in 0..=m {
            for j in 0..=n {
                let p = i + j - 1;
                if i > 0 {
                    dp[i][j] |= dp[i - 1][j] && s1[i - 1] == s3[p];
                }
                if j > 0 {
                    dp[i][j] |= dp[i][j - 1] && s2[j - 1] == s3[p];
                }
            }
        }
        dp[m][n]
    }
}