impl Solution {
    pub fn delete_string(s: String) -> i32 {
        
        let mut s = s.into_bytes();
        let n = s.len();
        let mut dp = vec![0; n];
        for i in 0..n {
            dp[i] = i;
            for j in 0..i {
                if s[j..i] == s[(j + i) / 2..i + (j + i) / 2] {
                    dp[i] = dp[i].min(dp[j] + i / (i - j) - 1);
                }
            }
        }
        dp[n - 1] as i32
    }
}