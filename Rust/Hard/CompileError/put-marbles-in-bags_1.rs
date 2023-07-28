impl Solution {
    pub fn put_marbles(weights: Vec<i32>, k: i32) -> i64 {
        
        let k = k as usize;
        let n = weights.len();
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + weights[i];
        }
        let mut dp = vec![vec![0; k + 1]; n + 1];
        for i in 1..=n {
            dp[i][1] = sum[i];
        }
        for i in 2..=n {
            for j in 2..=k {
                let mut min = i64::max_value();
                for x in 1..i {
                    let s = dp[x][j - 1] + (sum[i] - sum[x]) * (sum[i] - sum[x]);
                    if s < min {
                        min = s;
                    }
                }
                dp[i][j] = min;
            }
        }
        let mut max = i64::min_value();
        let mut min = i64::max_value();
        for i in 1..=n {
            if dp[i][k] > max {
                max = dp[i][k];
            }
            if dp[i][k] < min {
                min = dp[i][k];
            }
        }
        (max - min) as i64
    }
}