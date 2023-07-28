impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![false; n];
        dp[0] = true;
        let mut l = 0;
        let mut r = 0;
        for i in 1..n {
            if i as i32 >= min_jump {
                l += dp[i - min_jump as usize] as i32;
            }
            if i as i32 > max_jump {
                r += dp[i - max_jump as usize - 1] as i32;
            }
            dp[i] = l > r && s[i] == b'0';
        }
        dp[n - 1]
    }
}