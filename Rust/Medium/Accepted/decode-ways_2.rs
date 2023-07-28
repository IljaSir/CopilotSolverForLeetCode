impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        

        let mut dp = vec![0; s.len() + 1];
        dp[0] = 1;
        for i in 1..=s.len() {
            if s.as_bytes()[i - 1] != b'0' {
                dp[i] += dp[i - 1];
            }
            if i > 1 {
                let n = (s.as_bytes()[i - 2] - b'0') * 10 + s.as_bytes()[i - 1] - b'0';
                if n >= 10 && n <= 26 {
                    dp[i] += dp[i - 2];
                }
            }
        }
        dp[s.len()]
    }
}