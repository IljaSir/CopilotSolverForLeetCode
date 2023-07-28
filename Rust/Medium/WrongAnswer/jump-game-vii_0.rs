impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![false; n];
        dp[0] = true;
        let mut sum = 1;
        for i in 1..n {
            if i >= min_jump as usize {
                sum -= dp[i - min_jump as usize] as i32;
            }
            if i > max_jump as usize {
                sum += dp[i - max_jump as usize - 1] as i32;
            }
            dp[i] = sum > 0 && s[i] == b'0';
        }
        dp[n - 1]
    }
}