impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let mut dp = vec![0; stone_value.len() + 3];
        for i in (0..stone_value.len()).rev() {
            dp[i] = i32::min_value();
            for k in 0..3 {
                if i + k < stone_value.len() {
                    dp[i] = i32::max(dp[i], stone_value[i + k] - dp[i + k + 1]);
                }
            }
        }
        if dp[0] > 0 {
            "Alice".to_owned()
        } else if dp[0] < 0 {
            "Bob".to_owned()
        } else {
            "Tie".to_owned()
        }
    }
}