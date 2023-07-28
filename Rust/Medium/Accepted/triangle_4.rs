impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = vec![0; triangle.len()];
        dp[0] = triangle[0][0];
        for i in 1..triangle.len() {
            for j in (0..i + 1).rev() {
                if j == 0 {
                    dp[j] = dp[j] + triangle[i][j];
                } else if j == i {
                    dp[j] = dp[j - 1] + triangle[i][j];
                } else {
                    dp[j] = std::cmp::min(dp[j - 1], dp[j]) + triangle[i][j];
                }
            }
        }
        let mut min = dp[0];
        for i in 1..dp.len() {
            min = std::cmp::min(min, dp[i]);
        }
        min
    }
}