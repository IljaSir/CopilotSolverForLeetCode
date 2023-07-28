impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let n = stone_value.len();
        let mut dp = vec![0; n+3];
        for i in (0..n).rev() {
            let mut sum = 0;
            dp[i] = i32::min_value();
            for j in 0..3 {
                if i+j < n {
                    sum += stone_value[i+j];
                    dp[i] = dp[i].max(sum - dp[i+j+1]);
                }
            }
        }
        match dp[0].cmp(&0) {
            std::cmp::Ordering::Less => "Bob".to_string(),
            std::cmp::Ordering::Equal => "Tie".to_string(),
            std::cmp::Ordering::Greater => "Alice".to_string(),
        }
    }
}