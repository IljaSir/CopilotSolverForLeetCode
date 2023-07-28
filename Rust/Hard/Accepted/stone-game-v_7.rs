impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        
        let n = stone_value.len();
        let mut dp: Vec<Vec<i32>> = vec![vec![0; n]; n];
        let mut sum: Vec<i32> = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + stone_value[i];
        }
        for len in 2..=n {
            for i in 0..=n - len {
                let j = i + len - 1;
                for k in i..j {
                    let left = sum[k + 1] - sum[i];
                    let right = sum[j + 1] - sum[k + 1];
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