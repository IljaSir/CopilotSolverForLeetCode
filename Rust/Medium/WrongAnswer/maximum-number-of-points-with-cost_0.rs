impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let m = points.len();
        let n = points[0].len();
        let mut dp = vec![vec![0; n]; m];
        for i in 0..n {
            dp[0][i] = points[0][i] as i64;
        }
        for i in 1..m {
            let mut max = 0;
            let mut max_idx = 0;
            for j in 0..n {
                if dp[i - 1][j] > max {
                    max = dp[i - 1][j];
                    max_idx = j;
                }
            }
            for j in 0..n {
                dp[i][j] = max - (max_idx as i64 - j as i64).abs() + points[i][j] as i64;
            }
        }
        let mut max = 0;
        for i in 0..n {
            if dp[m - 1][i] > max {
                max = dp[m - 1][i];
            }
        }
        max
    }
}