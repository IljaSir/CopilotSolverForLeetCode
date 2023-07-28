impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = vec![vec![0; triangle.len()]; triangle.len()];
        dp[0][0] = triangle[0][0];
        for i in 1..triangle.len() {
            for j in 0..triangle[i].len() {
                if j == 0 {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if j == triangle[i].len() - 1 {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = std::cmp::min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        let mut res = dp[triangle.len() - 1][0];
        for i in 1..triangle.len() {
            res = std::cmp::min(res, dp[triangle.len() - 1][i]);
        }
        res
    }
}