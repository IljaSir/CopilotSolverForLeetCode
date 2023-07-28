impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = vec![vec![0; triangle.len()]; triangle.len()];
        dp[0][0] = triangle[0][0];
        for i in 1..triangle.len() {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for j in 1..triangle[i].len() - 1 {
                dp[i][j] = triangle[i][j] + std::cmp::min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
        let mut min = std::i32::MAX;
        for i in 0..triangle.len() {
            if dp[triangle.len() - 1][i] < min {
                min = dp[triangle.len() - 1][i];
            }
        }
        min
    }
}