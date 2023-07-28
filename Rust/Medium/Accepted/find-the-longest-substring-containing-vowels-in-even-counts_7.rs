impl Solution {
    pub fn find_the_longest_substring(s: String) -> i32 {
        
        let mut dp = vec![s.len(); 1 << 5];
        dp[0] = 0;
        let mut state = 0;
        let mut res = 0;
        for (i, &b) in s.as_bytes().iter().enumerate() {
            match b {
                b'a' => state ^= 1 << 0,
                b'e' => state ^= 1 << 1,
                b'i' => state ^= 1 << 2,
                b'o' => state ^= 1 << 3,
                b'u' => state ^= 1 << 4,
                _ => (),
            }
            dp[state] = dp[state].min(i + 1);
            res = res.max(i + 1 - dp[state]);
        }
        res as i32
    }
}