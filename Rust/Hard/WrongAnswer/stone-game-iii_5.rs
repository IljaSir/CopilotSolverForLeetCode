impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let mut dp = vec![0; stone_value.len()];
        let mut sum = 0;
        for i in (0..stone_value.len()).rev() {
            sum += stone_value[i];
            dp[i] = sum;
            for j in 1..=3 {
                if i+j < stone_value.len() {
                    dp[i] = std::cmp::max(dp[i], sum - dp[i+j]);
                }
            }
        }
        let alice = dp[0];
        let bob = sum - alice;
        if alice > bob {
            "Alice".to_string()
        } else if alice < bob {
            "Bob".to_string()
        } else {
            "Tie".to_string()
        }
    }
}