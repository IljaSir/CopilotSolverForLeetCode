impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        
        let mut dp = vec![0; s.len()];
        let mut s = s.as_bytes();
        let mut i = 0;
        while i < s.len() {
            if s[i] == b'0' {
                if i == 0 {
                    return 0;
                }
                if i == 1 {
                    if s[0] == b'1' || s[0] == b'2' {
                        dp[0] = 1;
                    } else {
                        return 0;
                    }
                }
                if s[i - 1] == b'1' || s[i - 1] == b'2' {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else if s[i] == b'*' {
                if i == 0 {
                    dp[0] = 9;
                } else {
                    dp[i] = dp[i - 1] * 9;
                    if s[i - 1] == b'1' {
                        dp[i] += dp[i - 2] * 9;
                    } else if s[i - 1] == b'2' {
                        dp[i] += dp[i - 2] * 6;
                    } else if s[i - 1] == b'*' {
                        dp[i] += dp[i - 2] * 15;
                    }
                }
            } else {
                if i == 0 {
                    dp[0] = 1;
                } else {
                    dp[i] = dp[i - 1];
                    if s[i - 1] == b'1' || (s[i - 1] == b'2' && s[i] <= b'6') {
                        dp[i] += dp[i - 2];
                    } else if s[i - 1] == b'*' {
                        dp[i] += dp[i - 2] * if s[i] <= b'6' { 2 } else { 1 };
                    }
                }
            }
            i += 1;
        }
        dp[s.len() - 1] as i32 % 1000000007
    }
}