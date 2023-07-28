impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        
        let s: Vec<char> = s.chars().collect();
        let mut dp = vec![false; s.len()];
        dp[0] = true;
        let (mut left, mut right) = (0, 0);
        for i in 1..s.len() {
            if i as i32 >= min_jump {
                left += dp[i - min_jump as usize] as i32;
            }
            if i as i32 > max_jump {
                right += dp[i - max_jump as usize - 1] as i32;
            }
            dp[i] = left > right && s[i] == '0';
        }
        dp[s.len() - 1]
    }
}