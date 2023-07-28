impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = triangle.clone();
        for i in 1..dp.len() {
            for j in 0..dp[i].len() {
                if j == 0 {
                    dp[i][j] += dp[i - 1][j];
                } else if j == dp[i].len() - 1 {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += dp[i - 1][j - 1].min(dp[i - 1][j]);
                }
            }
        }
        dp.last().unwrap().iter().min().unwrap().clone()
    }
}