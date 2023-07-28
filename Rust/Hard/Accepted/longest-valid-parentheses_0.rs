impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![0; n];
        let mut ans = 0;
        for i in 1..n {
            if s[i] == b')' {
                if s[i - 1] == b'(' {
                    dp[i] = if i >= 2 { dp[i - 2] } else { 0 } + 2;
                } else if i > dp[i - 1] && s[i - dp[i - 1] - 1] == b'(' {
                    dp[i] = dp[i - 1] + 2 + if i > dp[i - 1] + 1 { dp[i - dp[i - 1] - 2] } else { 0 };
                }
                ans = ans.max(dp[i]);
            }
        }
        ans as i32
    }
}