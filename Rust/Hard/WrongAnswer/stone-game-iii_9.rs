impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let mut dp = vec![0; stone_value.len()];
        let mut sum = vec![0; stone_value.len()];
        for i in (0..stone_value.len()).rev() {
            sum[i] = stone_value[i] + if i + 1 < stone_value.len() { sum[i + 1] } else { 0 };
            dp[i] = sum[i];
            if i + 1 < stone_value.len() {
                dp[i] = dp[i].max(sum[i] - dp[i + 1]);
            }
            if i + 2 < stone_value.len() {
                dp[i] = dp[i].max(sum[i] - dp[i + 2]);
            }
            if i + 3 < stone_value.len() {
                dp[i] = dp[i].max(sum[i] - dp[i + 3]);
            }
        }
        if dp[0] * 2 == sum[0] {
            return "Tie".to_string();
        }
        if dp[0] * 2 > sum[0] {
            return "Alice".to_string();
        }
        return "Bob".to_string();
    }
}