impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![0; n + 1];
        for i in 0..=n {
            dp[i] = i - 1;
        }
        for i in 0..n {
            let mut j = 0;
            while i >= j && i + j < n && s[i - j] == s[i + j] {
                dp[i + j + 1] = dp[i + j + 1].min(dp[i - j] + 1);
                j += 1;
            }
            j = 1;
            while i >= j - 1 && i + j < n && s[i - j + 1] == s[i + j] {
                dp[i + j + 1] = dp[i + j + 1].min(dp[i - j + 1] + 1);
                j += 1;
            }
        }
        dp[n] as i32
    }
}