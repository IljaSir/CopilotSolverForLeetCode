impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        if n == 0 { return 0; }
        let mut dp = vec![0; n + 1];
        dp[0] = 1;
        for i in 0..n {
            if s[i] == b'0' {
                continue;
            }
            let mut ways = 0;
            if s[i] == b'*' {
                ways += 9 * dp[i];
            } else {
                ways += dp[i];
            }
            if i > 0 {
                if s[i] == b'*' {
                    if s[i - 1] == b'1' {
                        ways += 9 * dp[i - 1];
                    } else if s[i - 1] == b'2' {
                        ways += 6 * dp[i - 1];
                    } else if s[i - 1] == b'*' {
                        ways += 15 * dp[i - 1];
                    }
                } else {
                    if s[i - 1] == b'1' {
                        ways += dp[i - 1];
                    } else if s[i - 1] == b'2' && s[i] <= b'6' {
                        ways += dp[i - 1];
                    } else if s[i - 1] == b'*' {
                        if s[i] <= b'6' {
                            ways += 2 * dp[i - 1];
                        } else {
                            ways += dp[i - 1];
                        }
                    }
                }
            }
            dp[i + 1] = ways % 1000000007;
        }
        dp[n]
    }
}