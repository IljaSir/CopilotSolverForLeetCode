impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        
        let n = stone_value.len();
        if n == 1 {
            return 0;
        }
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + stone_value[i];
        }
        let mut dp = vec![vec![0; n]; n];
        for i in (0..n).rev() {
            for j in i + 1..n {
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
        dp[0][n - 1]
    }
}