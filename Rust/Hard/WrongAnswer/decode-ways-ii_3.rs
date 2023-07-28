impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![0; n + 1];
        let modu = 1_000_000_007;
        dp[0] = 1;
        for i in 1..=n {
            let c = s[i - 1];
            if c == b'0' {
                if i == 1 || s[i - 2] != b'1' && s[i - 2] != b'2' {
                    return 0;
                }
                dp[i] = dp[i - 2];
            } else if c == b'*' {
                dp[i] = 9 * dp[i - 1];
                if i > 1 {
                    if s[i - 2] == b'1' {
                        dp[i] += 9 * dp[i - 2];
                    } else if s[i - 2] == b'2' {
                        dp[i] += 6 * dp[i - 2];
                    } else if s[i - 2] == b'*' {
                        dp[i] += 15 * dp[i - 2];
                    }
                }
            } else {
                dp[i] = dp[i - 1];
                if i > 1 {
                    if s[i - 2] == b'1' || s[i - 2] == b'2' && c <= b'6' {
                        dp[i] += dp[i - 2];
                    } else if s[i - 2] == b'*' {
                        if c <= b'6' {
                            dp[i] += 2 * dp[i - 2];
                        } else {
                            dp[i] += dp[i - 2];
                        }
                    }
                }
            }
            dp[i] %= modu;
        }
        dp[n] as i32
    }
}