impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        

        let mut dp = vec![vec![0; triangle.len()]; triangle.len()];
        for i in 0..triangle.len() {
            for j in 0..triangle[i].len() {
                let mut min = i32::MAX;
                if i > 0 {
                    if j > 0 {
                        min = min.min(dp[i-1][j-1]);
                    }
                    if j < triangle[i-1].len() {
                        min = min.min(dp[i-1][j]);
                    }
                }
                dp[i][j] = min + triangle[i][j];
            }
        }
        dp[triangle.len()-1].iter().min().unwrap().clone()
    }
}