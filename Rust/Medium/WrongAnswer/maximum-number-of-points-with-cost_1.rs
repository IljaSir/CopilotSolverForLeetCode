impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![vec![0i64; points[0].len()]; points.len()];
        dp[0] = points[0].iter().map(|x| *x as i64).collect();
        for i in 1..points.len() {
            let mut max = 0;
            for j in 0..points[i].len() {
                max = max.max(dp[i - 1][j]);
                dp[i][j] = max - j as i64 + points[i][j] as i64;
            }
            let mut max = 0;
            for j in (0..points[i].len()).rev() {
                max = max.max(dp[i - 1][j]);
                dp[i][j] = dp[i][j].max(max + j as i64 + points[i][j] as i64);
            }
        }
        *dp.last().unwrap().iter().max().unwrap()
    }
}