impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; stone_value.len()]; stone_value.len()];
        let mut sum = vec![0; stone_value.len() + 1];
        for i in 0..stone_value.len() {
            sum[i + 1] = sum[i] + stone_value[i];
        }
        for i in (0..stone_value.len()).rev() {
            for j in i + 1..stone_value.len() {
                for k in i..j {
                    let left = sum[k + 1] - sum[i];
                    let right = sum[j + 1] - sum[k + 1];
                    if left < right {
                        dp[i][j] = dp[i][j].max(dp[i][k] + left);
                    } else if left > right {
                        dp[i][j] = dp[i][j].max(dp[k + 1][j] + right);
                    } else {
                        dp[i][j] = dp[i][j].max(dp[i][k].max(dp[k + 1][j]) + left);
                    }
                }
            }
        }
        dp[0][stone_value.len() - 1]
    }
}