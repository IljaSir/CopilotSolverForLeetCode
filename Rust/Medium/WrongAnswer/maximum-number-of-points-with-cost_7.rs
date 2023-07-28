impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let mut dp = vec![0; points[0].len()];
        for r in 0..points.len() {
            let mut max = 0;
            let mut max_index = 0;
            for c in 0..points[r].len() {
                dp[c] = max + points[r][c] as i64;
                if dp[c] > max {
                    max = dp[c];
                    max_index = c;
                }
            }
            let mut min = 0;
            let mut min_index = 0;
            for c in (0..points[r].len()).rev() {
                dp[c] = min + points[r][c] as i64;
                if dp[c] > max {
                    max = dp[c];
                    max_index = c;
                }
                if dp[c] < min {
                    min = dp[c];
                    min_index = c;
                }
            }
            for c in 0..points[r].len() {
                if c != max_index {
                    dp[c] = max - (max_index as i64 - c as i64).abs() - points[r][c] as i64;
                }
                if c != min_index {
                    dp[c] = min + (min_index as i64 - c as i64).abs() - points[r][c] as i64;
                }
            }
        }
        *dp.iter().max().unwrap()
    }
}