impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![0; n + 1];
        dp[n] = 1;
        if s[n - 1] == b'*' {
            dp[n - 1] = 9;
        } else if s[n - 1] != b'0' {
            dp[n - 1] = 1;
        }
        for i in (0..n - 1).rev() {
            if s[i] == b'0' {
                continue;
            } else if s[i] == b'1' {
                if s[i + 1] == b'*' {
                    dp[i] = (dp[i] + 9 * dp[i + 1]) % 1000000007;
                } else {
                    dp[i] = (dp[i] + dp[i + 1]) % 1000000007;
                }
                if i < n - 2 {
                    if s[i + 2] == b'*' {
                        dp[i] = (dp[i] + 9 * dp[i + 2]) % 1000000007;
                    } else {
                        dp[i] = (dp[i] + dp[i + 2]) % 1000000007;
                    }
                }
            } else if s[i] == b'2' {
                if s[i + 1] == b'*' {
                    dp[i] = (dp[i] + 6 * dp[i + 1]) % 1000000007;
                } else if s[i + 1] < b'7' {
                    dp[i] = (dp[i] + dp[i + 1]) % 1000000007;
                }
                if i < n - 2 {
                    if s[i + 2] == b'*' {
                        dp[i] = (dp[i] + 6 * dp[i + 2]) % 1000000007;
                    } else if s[i + 2] < b'7' {
                        dp[i] = (dp[i] + dp[i + 2]) % 1000000007;
                    }
                }
            } else if s[i] == b'*' {
                dp[i] = (dp[i] + 9 * dp[i + 1]) % 100000000
    }
}