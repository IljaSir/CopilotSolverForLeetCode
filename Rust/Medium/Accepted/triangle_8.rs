impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        

        let mut triangle = triangle;
        let mut dp = vec![0; triangle.len()];
        for i in 0..triangle.len() {
            dp[i] = triangle[triangle.len() - 1][i];
        }
        for i in (0..triangle.len() - 1).rev() {
            for j in 0..triangle[i].len() {
                dp[j] = triangle[i][j] + dp[j].min(dp[j + 1]);
            }
        }
        dp[0]
    }
}