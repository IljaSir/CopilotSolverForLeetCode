impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        

        let mut dp = vec![0; s.len() + 1];
        dp[0] = 1;
        dp[1] = if s.chars().nth(0).unwrap() == '0' { 0 } else { 1 };
        for i in 2..=s.len() {
            let one = s.chars().nth(i - 1).unwrap() - '0';
            let two = (s.chars().nth(i - 2).unwrap() - '0') * 10 + one;
            if one >= 1 && one <= 9 {
                dp[i] += dp[i - 1];
            }
            if two >= 10 && two <= 26 {
                dp[i] += dp[i - 2];
            }
        }
        dp[s.len()]
    }
}