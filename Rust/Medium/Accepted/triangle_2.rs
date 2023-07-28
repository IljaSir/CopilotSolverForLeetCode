impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = vec![0; triangle.len()];
        dp[0] = triangle[0][0];
        for i in 1..triangle.len() {
            dp[i] = dp[i - 1] + triangle[i][i];
            for j in (1..i).rev() {
                dp[j] = triangle[i][j] + dp[j].min(dp[j - 1]);
            }
            dp[0] += triangle[i][0];
        }
        dp.iter().min().unwrap().clone()
    }
}