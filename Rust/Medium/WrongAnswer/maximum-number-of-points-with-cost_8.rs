impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let mut dp: Vec<i64> = vec![0; points[0].len()];
        let mut max: i64 = 0;
        for i in 0..points.len() {
            let mut max_val: i64 = 0;
            let mut max_idx: usize = 0;
            for j in 0..points[i].len() {
                if max_val < dp[j] + j as i64 {
                    max_val = dp[j] + j as i64;
                    max_idx = j;
                }
            }
            let mut min_val: i64 = 0;
            let mut min_idx: usize = 0;
            for j in 0..points[i].len() {
                if min_val > dp[j] - j as i64 {
                    min_val = dp[j] - j as i64;
                    min_idx = j;
                }
            }
            for j in 0..points[i].len() {
                dp[j] = points[i][j] as i64 + max_val - max_idx as i64;
                if j != max_idx {
                    dp[j] = dp[j].max(points[i][j] as i64 + min_val - min_idx as i64);
                }
                max = max.max(dp[j]);
            }
        }
        max
    }
}