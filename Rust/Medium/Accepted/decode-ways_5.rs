impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        

        let n = s.len();
        if n == 0 {
            return 0;
        }
        let s = s.as_bytes();
        let mut dp = vec![0; n + 1];
        dp[0] = 1;
        dp[1] = if s[0] == b'0' { 0 } else { 1 };
        for i in 2..=n {
            let one = s[i - 1] - b'0';
            let two = (s[i - 2] - b'0') * 10 + one;
            if 1 <= one && one <= 9 {
                dp[i] += dp[i - 1];
            }
            if 10 <= two && two <= 26 {
                dp[i] += dp[i - 2];
            }
        }
        dp[n]
    }
}