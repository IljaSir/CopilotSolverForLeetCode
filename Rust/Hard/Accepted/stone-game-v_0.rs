impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        
        let n = stone_value.len();
        let mut sum = vec![0; n + 1];
        for i in 1..=n {
            sum[i] = sum[i - 1] + stone_value[i - 1];
        }
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 0;
        }
        for l in 2..=n {
            for i in 0..n - l + 1 {
                let j = i + l - 1;
                for k in i..j {
                    let left = sum[k + 1] - sum[i];
                    let right = sum[j + 1] - sum[k + 1];
                    if left < right {
                        dp[i][j] = std::cmp::max(dp[i][j], dp[i][k] + left);
                    } else if left > right {
                        dp[i][j] = std::cmp::max(dp[i][j], dp[k + 1][j] + right);
                    } else {
                        dp[i][j] = std::cmp::max(dp[i][j], std::cmp::max(dp[i][k], dp[k + 1][j]) + left);
                    }
                }
            }
        }
        dp[0][n - 1]
    }
}