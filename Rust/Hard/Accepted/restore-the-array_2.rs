impl Solution {
    pub fn number_of_arrays(s: String, k: i32) -> i32 {
        
        let s = s.as_bytes();
        let k = k as usize;
        let s_len = s.len();
        let mut dp = vec![0; s_len + 1];
        dp[s_len] = 1;
        for i in (0..s_len).rev() {
            if s[i] == b'0' {
                continue;
            }
            let mut num = 0;
            let mut j = i;
            while j < s_len && num <= k {
                num = num * 10 + (s[j] - b'0') as usize;
                j += 1;
                if num <= k {
                    dp[i] += dp[j];
                    dp[i] %= 1_000_000_007;
                }
            }
        }
        dp[0] as i32
    }
}