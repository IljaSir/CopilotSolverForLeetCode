impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let n = stone_value.len();
        let mut dp = vec![0; n+1];
        for i in (0..n).rev() {
            let mut sum = 0;
            dp[i] = i32::MIN;
            for j in 0..3 {
                if i+j < n {
                    sum += stone_value[i+j];
                    dp[i] = i32::max(dp[i], sum - dp[i+j+1]);
                }
            }
        }
        if dp[0] > 0 { "Alice" } else if dp[0] == 0 { "Tie" } else { "Bob" }.to_string()
    }
}