impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        

        let s = s.as_bytes();
        let mut dp = vec![0; s.len() + 1];
        dp[0] = 1;
        for i in 1..=s.len() {
            if s[i - 1] != b'0' {
                dp[i] += dp[i - 1];
            }
            if i > 1 && (s[i - 2] == b'1' || (s[i - 2] == b'2' && s[i - 1] <= b'6')) {
                dp[i] += dp[i - 2];
            }
        }
        dp[s.len()]
    }
}