impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let s = s.as_bytes();
        let mut dp = vec![false; s.len()];
        dp[0] = true;
        let mut sum = 0;
        for i in 1..s.len() {
            if s[i] == b'0' {
                let min = (i as i32 - max_jump).max(0) as usize;
                let max = (i as i32 - min_jump).max(0) as usize;
                if min > 0 {
                    sum -= dp[min - 1] as i32;
                }
                sum += dp[max] as i32;
                dp[i] = sum > 0;
            }
        }
        dp[s.len() - 1]
    }
}