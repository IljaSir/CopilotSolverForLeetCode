impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let n = s.len();
        let mut dp = vec![false; n];
        dp[0] = true;
        let mut pre = 0;
        for i in 1..n {
            if i as i32 >= min_jump {
                pre += dp[i - min_jump as usize] as i32;
            }
            if i as i32 > max_jump {
                pre -= dp[i - max_jump as usize - 1] as i32;
            }
            if pre > 0 && s.as_bytes()[i] == b'0' {
                dp[i] = true;
            }
        }
        dp[n - 1]
    }
}