impl Solution {
    pub fn min_side_jumps(obstacles: Vec<i32>) -> i32 {
        
        let n = obstacles.len();
        let mut dp = vec![vec![1; 3]; n];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for i in 1..n {
            for j in 0..3 {
                if obstacles[i] == j as i32 + 1 {
                    dp[i][j] = 1 << 30;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            for j in 0..3 {
                if obstacles[i] != j as i32 + 1 {
                    for k in 0..3 {
                        if j != k {
                            dp[i][j] = dp[i][j].min(dp[i][k] + 1);
                        }
                    }
                }
            }
        }
        dp[n - 1][1].min(dp[n - 1][0].min(dp[n - 1][2]))
    }
}