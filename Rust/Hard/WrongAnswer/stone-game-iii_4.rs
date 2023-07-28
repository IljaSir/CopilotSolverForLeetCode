impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let mut dp = vec![0; stone_value.len()];
        let mut sum = vec![0; stone_value.len()];
        sum[stone_value.len() - 1] = stone_value[stone_value.len() - 1];
        for i in (0..stone_value.len() - 1).rev() {
            sum[i] = sum[i + 1] + stone_value[i];
        }
        dp[stone_value.len() - 1] = stone_value[stone_value.len() - 1];
        if stone_value.len() > 1 {
            dp[stone_value.len() - 2] = stone_value[stone_value.len() - 2] + stone_value[stone_value.len() - 1];
        }
        if stone_value.len() > 2 {
            dp[stone_value.len() - 3] = stone_value[stone_value.len() - 3] + stone_value[stone_value.len() - 2] + stone_value[stone_value.len() - 1];
        }
        for i in (0..stone_value.len() - 3).rev() {
            dp[i] = sum[i] - dp[i + 1].min(dp[i + 2].min(dp[i + 3]));
        }
        let alice = dp[0];
        let bob = sum[0] - alice;
        if alice > bob {
            "Alice".to_string()
        } else if alice < bob {
            "Bob".to_string()
        } else {
            "Tie".to_string()
        }
    }
}