impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let n = stone_value.len();
        let mut dp = vec![0; n + 1];
        dp[n] = 0;
        for i in (0..n).rev() {
            let mut sum = 0;
            for j in 0..3 {
                if i + j < n {
                    sum += stone_value[i + j];
                    dp[i] = dp[i].max(sum - dp[i + j + 1]);
                }
            }
        }
        if dp[0] > 0 {
            "Alice".to_string()
        } else if dp[0] < 0 {
            "Bob".to_string()
        } else {
            "Tie".to_string()
        }
    }
}