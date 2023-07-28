impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        

        let mut dp = vec![0; s.len() + 1];
        dp[0] = 1;
        for i in 1..=s.len() {
            let mut a = 0;
            let mut b = 0;
            if s.as_bytes()[i - 1] != b'0' {
                a = dp[i - 1];
            }
            if i > 1 && s.as_bytes()[i - 2] != b'0' {
                let num = (s.as_bytes()[i - 2] - b'0') * 10 + (s.as_bytes()[i - 1] - b'0');
                if num <= 26 {
                    b = dp[i - 2];
                }
            }
            dp[i] = a + b;
        }
        dp[s.len()]
    }
}