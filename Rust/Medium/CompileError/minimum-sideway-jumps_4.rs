impl Solution {
    pub fn min_side_jumps(obstacles: Vec<i32>) -> i32 {
        
        let n = obstacles.len();
        let mut dp = vec![vec![1; 4]; n + 1];
        dp[0][2] = 0;
        for i in 1..n + 1 {
            let mut min = std::i32::MAX;
            for j in 1..=3 {
                if obstacles[i-1] != j {
                    min = min.min(dp[i-1][j]);
                }
            }
            for j in 1..=3 {
                if obstacles[i-1] != j {
                    dp[i][j] = min.min(dp[i][j]);
                }
            }
            for j in 1..=3 {
                if obstacles[i] != j {
                    dp[i][j] = dp[i][j].min(dp[i][j-1] + 1).min(dp[i][j+1] + 1);
                }
            }
        }
        dp[n][2]
    }
}