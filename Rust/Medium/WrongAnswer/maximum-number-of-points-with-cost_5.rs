impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![0; points[0].len()];
        for row in points.iter() {
            let mut max = 0;
            for i in 0..row.len() {
                max = max.max(dp[i]);
            }
            let mut min = i64::MAX;
            for i in 0..row.len() {
                min = min.min(max - i as i64);
                dp[i] = min + i as i64 + row[i] as i64;
            }
            let mut max = 0;
            for i in (0..row.len()).rev() {
                max = max.max(dp[i]);
            }
            let mut min = i64::MAX;
            for i in (0..row.len()).rev() {
                min = min.min(max - (row.len() - i - 1) as i64);
                dp[i] = min + (row.len() - i - 1) as i64 + row[i] as i64;
            }
        }
        let mut max = 0;
        for i in 0..dp.len() {
            max = max.max(dp[i]);
        }
        max
    }
}