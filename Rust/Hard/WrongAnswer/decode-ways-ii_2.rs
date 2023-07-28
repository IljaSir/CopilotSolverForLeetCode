impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        
        let n = s.len();
        let modu = 1000000007;
        let mut dp = vec![0; n + 1];
        dp[0] = 1;
        for i in 0..n {
            if s.as_bytes()[i] == b'0' {
                dp[i + 1] = 0;
            } else if s.as_bytes()[i] == b'*' {
                dp[i + 1] = 9 * dp[i];
            } else {
                dp[i + 1] = dp[i];
            }
            if i > 0 {
                if s.as_bytes()[i - 1] == b'1' {
                    if s.as_bytes()[i] == b'*' {
                        dp[i + 1] += 9 * dp[i - 1];
                    } else {
                        dp[i + 1] += dp[i - 1];
                    }
                } else if s.as_bytes()[i - 1] == b'2' {
                    if s.as_bytes()[i] == b'*' {
                        dp[i + 1] += 6 * dp[i - 1];
                    } else if s.as_bytes()[i] <= b'6' {
                        dp[i + 1] += dp[i - 1];
                    }
                } else if s.as_bytes()[i - 1] == b'*' {
                    if s.as_bytes()[i] == b'*' {
                        dp[i + 1] += 15 * dp[i - 1];
                    } else if s.as_bytes()[i] <= b'6' {
                        dp[i + 1] += 2 * dp[i - 1];
                    } else {
                        dp[i + 1] += dp[i - 1];
                    }
                }
            }
            dp[i + 1] %= modu;
        }
        dp[n]
    }
}