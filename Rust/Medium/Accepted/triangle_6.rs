impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = vec![0; triangle.len()];
        for i in 0..triangle.len() {
            for j in (0..=i).rev() {
                if j == 0 {
                    dp[j] += triangle[i][j];
                } else if j == i {
                    dp[j] = dp[j - 1] + triangle[i][j];
                } else {
                    dp[j] = dp[j - 1].min(dp[j]) + triangle[i][j];
                }
            }
        }
        dp.iter().min().unwrap().to_owned()
    }
}