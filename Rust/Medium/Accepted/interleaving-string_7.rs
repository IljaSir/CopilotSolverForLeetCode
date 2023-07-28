impl Solution {
    pub fn is_interleave(s1: String, s2: String, s3: String) -> bool {
        

        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let s3 = s3.as_bytes();
        let (n, m, l) = (s1.len(), s2.len(), s3.len());
        if n + m != l {
            return false;
        }
        let mut dp = vec![vec![false; m + 1]; n + 1];
        dp[0][0] = true;
        for i in 0..=n {
            for j in 0..=m {
                let p = i + j - 1;
                if i > 0 {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1[i - 1] == s3[p]);
                }
                if j > 0 {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2[j - 1] == s3[p]);
                }
            }
        }
        dp[n][m]
    }
}