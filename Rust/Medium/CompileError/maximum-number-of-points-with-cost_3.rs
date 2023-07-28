impl Solution {
    pub fn max_points(points: Vec<Vec<i32>>) -> i64 {
        
        let m = points.len();
        let n = points[0].len();
        let mut dp = vec![0; n];
        for i in 0..m {
            let mut max = 0;
            let mut max_j = 0;
            for j in 0..n {
                if dp[j] > max {
                    max = dp[j];
                    max_j = j;
                }
            }
            let mut max2 = 0;
            for j in 0..n {
                if j == max_j {
                    dp[j] = max;
                } else {
                    if dp[j] > max2 {
                        max2 = dp[j];
                    }
                }
            }
            for j in 0..n {
                dp[j] = max2 + (max_j as i32 - j as i32).abs() + points[i][j];
            }
        }
        let mut max = 0;
        for j in 0..n {
            if dp[j] > max {
                max = dp[j];
            }
        }
        max
    }
}