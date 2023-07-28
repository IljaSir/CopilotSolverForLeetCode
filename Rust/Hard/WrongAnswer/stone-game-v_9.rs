impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; stone_value.len()]; stone_value.len()];
        let mut prefix_sum = vec![0; stone_value.len() + 1];
        for i in 1..=stone_value.len() {
            prefix_sum[i] = prefix_sum[i - 1] + stone_value[i - 1];
        }
        for i in 0..stone_value.len() {
            dp[i][i] = stone_value[i];
        }
        for len in 2..=stone_value.len() {
            for i in 0..=stone_value.len() - len {
                let j = i + len - 1;
                let mut max_score = 0;
                for k in i..j {
                    let left_sum = prefix_sum[k + 1] - prefix_sum[i];
                    let right_sum = prefix_sum[j + 1] - prefix_sum[k + 1];
                    if left_sum < right_sum {
                        max_score = max_score.max(dp[i][k] + left_sum);
                    } else if left_sum > right_sum {
                        max_score = max_score.max(dp[k + 1][j] + right_sum);
                    } else {
                        max_score = max_score.max(dp[i][k] + left_sum);
                        max_score = max_score.max(dp[k + 1][j] + right_sum);
                    }
                }
                dp[i][j] = max_score;
            }
        }
        dp[0][stone_value.len() - 1]
    }
}