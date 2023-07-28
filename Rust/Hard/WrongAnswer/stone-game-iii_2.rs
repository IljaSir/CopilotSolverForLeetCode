impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let mut dp = vec![0; stone_value.len()];
        let mut sum = 0;
        for i in (0..stone_value.len()).rev() {
            sum += stone_value[i];
            dp[i] = sum - dp[i];
            if i + 1 < stone_value.len() {
                dp[i] = dp[i].max(sum - stone_value[i + 1] - dp[i + 1]);
            }
            if i + 2 < stone_value.len() {
                dp[i] = dp[i].max(sum - stone_value[i + 1] - stone_value[i + 2] - dp[i + 2]);
            }
        }
        if dp[0] * 2 == sum {
            "Tie".to_string()
        } else if dp[0] * 2 > sum {
            "Alice".to_string()
        } else {
            "Bob".to_string()
        }
    }
}