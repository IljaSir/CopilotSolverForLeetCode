impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![vec![0; points[0].len()]; 2];
        let mut ans = 0;
        for i in 0..points.len() {
            let mut max = 0;
            for j in 0..points[0].len() {
                max = max.max(dp[(i + 1) % 2][j]);
            }
            for j in 0..points[0].len() {
                dp[i % 2][j] = max - (points[i][j] as i64).abs();
            }
            max = 0;
            for j in (0..points[0].len()).rev() {
                max = max.max(dp[(i + 1) % 2][j]);
                dp[i % 2][j] = max - (points[i][j] as i64).abs();
            }
            for j in 0..points[0].len() {
                dp[i % 2][j] += points[i][j] as i64;
                ans = ans.max(dp[i % 2][j]);
            }
        }
        ans
    }
}