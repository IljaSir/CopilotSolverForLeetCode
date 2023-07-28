impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let n = stone_value.len();
        let mut dp = vec![0; n + 1];
        for i in (0..n).rev() {
            let mut sum = 0;
            let mut max = std::i32::MIN;
            for j in 0..3 {
                if i + j < n {
                    sum += stone_value[i + j];
                    max = std::cmp::max(max, sum - dp[i + j + 1]);
                }
            }
            dp[i] = max;
        }
        if dp[0] == 0 {
            "Tie".to_string()
        } else if dp[0] > 0 {
            "Alice".to_string()
        } else {
            "Bob".to_string()
        }
    }
}