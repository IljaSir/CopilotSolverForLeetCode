impl Solution {
    pub fn put_marbles(weights: Vec<i32>, k: i32) -> i64 {
        
        let mut dp = vec![vec![0; weights.len()]; k as usize];
        let mut sum = vec![0; weights.len()];
        sum[0] = weights[0] as i64;
        for i in 1..weights.len() {
            sum[i] = sum[i - 1] + weights[i] as i64;
        }
        for i in 0..k as usize {
            for j in i..weights.len() {
                if i == 0 {
                    dp[i][j] = sum[j] as i64;
                } else {
                    let mut min = std::i64::MAX;
                    for l in 0..j {
                        let s = dp[i - 1][l] + (sum[j] - sum[l]) as i64;
                        if s < min {
                            min = s;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        let mut max = 0;
        let mut min = std::i64::MAX;
        for i in 0..weights.len() {
            if dp[k as usize - 1][i] > max {
                max = dp[k as usize - 1][i];
            }
            if dp[k as usize - 1][i] < min {
                min = dp[k as usize - 1][i];
            }
        }
        return max - min;
    }
}