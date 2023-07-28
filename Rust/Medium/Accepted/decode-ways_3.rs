impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        

        let mut dp = vec![0; s.len() + 1];
        dp[0] = 1;
        dp[1] = if s.as_bytes()[0] == b'0' { 0 } else { 1 };
        for i in 2..=s.len() {
            let first = s.as_bytes()[i - 1] - b'0';
            let second = (s.as_bytes()[i - 2] - b'0') * 10 + (s.as_bytes()[i - 1] - b'0');
            if first >= 1 && first <= 9 {
                dp[i] += dp[i - 1];
            }
            if second >= 10 && second <= 26 {
                dp[i] += dp[i - 2];
            }
        }
        dp[s.len()]
    }
}