impl Solution {
    pub fn split_string(s: String) -> bool {
        
        let n = s.len();
        let s = s.as_bytes();
        let mut dp = vec![false; n];
        for i in 1..n {
            dp[i] = (s[i] == b'0') || (i > 1 && dp[i - 2]);
        }
        for i in 1..n {
            if s[i] == b'0' {
                continue;
            }
            let mut num = 0;
            for j in (0..i).rev() {
                num += (s[j] - b'0') as i32;
                if j > 0 && dp[j - 1] {
                    continue;
                }
                if i - j + 1 < 10 || num == (s[i] - b'0') as i32 + 1 {
                    dp[i] = true;
                    break;
                }
            }
        }
        dp[n - 1]
    }
}