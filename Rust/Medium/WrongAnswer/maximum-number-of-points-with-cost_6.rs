impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![0; points[0].len()];
        for row in points {
            let mut max = 0;
            for j in 0..row.len() {
                max = std::cmp::max(max, dp[j]);
                dp[j] = max - j as i32 + row[j];
            }
            let mut max = 0;
            for j in (0..row.len()).rev() {
                max = std::cmp::max(max, dp[j]);
                dp[j] = std::cmp::max(dp[j], max + j as i32 + row[j]);
            }
        }
        dp.into_iter().max().unwrap() as i64
    }
}