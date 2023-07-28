impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        
        let mut dp = vec![0; stone_value.len()];
        let mut sum = vec![0; stone_value.len()];
        sum[stone_value.len() - 1] = stone_value[stone_value.len() - 1];
        for i in (0..stone_value.len() - 1).rev() {
            sum[i] = sum[i + 1] + stone_value[i];
        }
        for i in (0..stone_value.len()).rev() {
            dp[i] = sum[i] - dp[i];
            if i + 1 < stone_value.len() {
                dp[i] = std::cmp::max(dp[i], sum[i] - dp[i + 1]);
            }
            if i + 2 < stone_value.len() {
                dp[i] = std::cmp::max(dp[i], sum[i] - dp[i + 2]);
            }
            if i + 3 < stone_value.len() {
                dp[i] = std::cmp::max(dp[i], sum[i] - dp[i + 3]);
            }
        }
        if dp[0] == sum[0] - dp[0] {
            return String::from("Tie");
        } else if dp[0] > sum[0] - dp[0] {
            return String::from("Alice");
        } else {
            return String::from("Bob");
        }
    }
}