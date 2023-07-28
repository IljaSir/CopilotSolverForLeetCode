impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let s = s.as_bytes();
        let n = s.len() as i32;
        let mut dp = vec![false; n as usize];
        dp[0] = true;
        let mut sum = 1;
        for i in 1..n {
            if i >= min_jump {
                sum -= dp[(i - min_jump) as usize] as i32;
            }
            if i > max_jump {
                sum += dp[(i - max_jump - 1) as usize] as i32;
            }
            dp[i as usize] = sum > 0 && s[i as usize] == b'0';
        }
        dp[n as usize - 1]
    }
}