impl Solution {
    pub fn is_interleave(s1: String, s2: String, s3: String) -> bool {
        

        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let s3 = s3.as_bytes();
        let n1 = s1.len();
        let n2 = s2.len();
        let n3 = s3.len();
        if n1 + n2 != n3 {
            return false;
        }
        let mut dp = vec![vec![false; n2 + 1]; n1 + 1];
        dp[0][0] = true;
        for i in 0..=n1 {
            for j in 0..=n2 {
                let p = i + j - 1;
                if i > 0 {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1[i - 1] == s3[p]);
                }
                if j > 0 {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2[j - 1] == s3[p]);
                }
            }
        }
        dp[n1][n2]
    }
}