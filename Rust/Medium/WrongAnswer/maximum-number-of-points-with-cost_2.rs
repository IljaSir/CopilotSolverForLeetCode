impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let m = points.len();
        let n = points[0].len();
        let mut dp = vec![vec![0; n]; 2];
        for i in 0..m {
            let mut max = 0;
            for j in 0..n {
                max = max.max(dp[(i - 1) % 2][j]);
                dp[i % 2][j] = max - j as i32 + points[i][j];
            }
            max = 0;
            for j in (0..n).rev() {
                max = max.max(dp[(i - 1) % 2][j]);
                dp[i % 2][j] = max + j as i32 + points[i][j];
            }
        }
        dp[(m - 1) % 2].iter().max().unwrap().clone() as i64
    }
}