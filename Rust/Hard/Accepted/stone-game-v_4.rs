impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; stone_value.len()]; stone_value.len()];
        let mut sum = vec![0; stone_value.len()];
        sum[0] = stone_value[0];
        for i in 1..stone_value.len() {
            sum[i] = sum[i - 1] + stone_value[i];
        }
        for len in 2..=stone_value.len() {
            for i in 0..(stone_value.len() - len + 1) {
                let j = i + len - 1;
                for k in i..j {
                    let left = sum[k] - if i > 0 { sum[i - 1] } else { 0 };
                    let right = sum[j] - sum[k];
                    if left < right {
                        dp[i][j] = dp[i][j].max(dp[i][k] + left);
                    } else if left > right {
                        dp[i][j] = dp[i][j].max(dp[k + 1][j] + right);
                    } else {
                        dp[i][j] = dp[i][j].max(dp[i][k] + left);
                        dp[i][j] = dp[i][j].max(dp[k + 1][j] + right);
                    }
                }
            }
        }
        dp[0][stone_value.len() - 1]
    }
}