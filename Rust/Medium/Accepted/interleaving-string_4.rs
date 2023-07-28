impl Solution {
    pub fn is_interleave(s1: String, s2: String, s3: String) -> bool {
        

        let (s1, s2, s3) = (s1.as_bytes(), s2.as_bytes(), s3.as_bytes());
        if s3.len() != s1.len() + s2.len() {
            return false;
        }
        let mut dp = vec![false; s2.len() + 1];
        dp[0] = true;
        for j in 1..=s2.len() {
            dp[j] = dp[j - 1] && s2[j - 1] == s3[j - 1];
        }
        for i in 1..=s1.len() {
            dp[0] = dp[0] && s1[i - 1] == s3[i - 1];
            for j in 1..=s2.len() {
                dp[j] = (s1[i - 1] == s3[i + j - 1] && dp[j])
                    || (s2[j - 1] == s3[i + j - 1] && dp[j - 1]);
            }
        }
        dp[s2.len()]
    }
}