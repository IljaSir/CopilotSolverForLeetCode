impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        
        let n = s.len();
        let mut dp = vec![0; n + 1];
        dp[n] = 1;
        let mut modu = 1_000_000_007;
        for i in (0..n).rev() {
            if s[i..i + 1] == "*" {
                dp[i] += dp[i + 1] * 9;
                if i + 1 < n {
                    if s[i + 1..i + 2] == "*" {
                        dp[i] += dp[i + 2] * 15;
                    } else if s[i + 1..i + 2] <= "6" {
                        dp[i] += dp[i + 2] * 2;
                    } else {
                        dp[i] += dp[i + 2];
                    }
                }
            } else if s[i..i + 1] != "0" {
                dp[i] += dp[i + 1];
                if i + 1 < n {
                    if s[i + 1..i + 2] == "*" {
                        if s[i..i + 1] <= "1" {
                            dp[i] += dp[i + 2] * 9;
                        } else {
                            dp[i] += dp[i + 2] * 7;
                        }
                    } else if s[i..i + 2] <= "26" {
                        dp[i] += dp[i + 2];
                    }
                }
            }
            dp[i] %= modu;
        }
        dp[0]
    }
}