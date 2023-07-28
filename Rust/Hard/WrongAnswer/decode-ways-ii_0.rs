impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        
        let mut dp = vec![0; s.len()+1];
        dp[0] = 1;
        dp[1] = match s.chars().nth(0).unwrap() {
            '*' => 9,
            '0' => 0,
            _ => 1,
        };
        let modulo = 10_i32.pow(9) + 7;
        for i in 1..s.len() {
            let c = s.chars().nth(i).unwrap();
            let p = s.chars().nth(i-1).unwrap();
            if c == '*' {
                dp[i+1] += dp[i] * 9;
                if p == '1' {
                    dp[i+1] += dp[i-1] * 9;
                } else if p == '2' {
                    dp[i+1] += dp[i-1] * 6;
                } else if p == '*' {
                    dp[i+1] += dp[i-1] * 15;
                }
            } else {
                if c != '0' {
                    dp[i+1] += dp[i];
                }
                if p == '1' {
                    dp[i+1] += dp[i-1];
                } else if p == '2' && c <= '6' {
                    dp[i+1] += dp[i-1];
                } else if p == '*' {
                    if c <= '6' {
                        dp[i+1] += dp[i-1] * 2;
                    } else {
                        dp[i+1] += dp[i-1];
                    }
                }
            }
            dp[i+1] %= modulo;
        }
        dp[s.len()]
    }
}