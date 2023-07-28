impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        
        let n = stone_value.len();
        let mut dp = vec![vec![0; n]; n];
        let mut pre_sum = vec![0; n + 1];
        for i in 0..n {
            pre_sum[i + 1] = pre_sum[i] + stone_value[i];
        }
        for i in (0..n).rev() {
            for j in i + 1..n {
                for k in i..j {
                    let left = pre_sum[k + 1] - pre_sum[i];
                    let right = pre_sum[j + 1] - pre_sum[k + 1];
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
        dp[0][n - 1]
    }
}