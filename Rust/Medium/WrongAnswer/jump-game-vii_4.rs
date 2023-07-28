impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let mut dp = vec![false; s.len()];
        dp[0] = true;
        let mut sum = 1;
        let min_jump = min_jump as usize;
        let max_jump = max_jump as usize;
        for i in 1..s.len() {
            if i >= min_jump {
                sum -= dp[i - min_jump] as usize;
            }
            if i > max_jump {
                sum += dp[i - max_jump - 1] as usize;
            }
            dp[i] = sum > 0 && s.as_bytes()[i] == b'0';
        }
        dp[s.len() - 1]
    }
}