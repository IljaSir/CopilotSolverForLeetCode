impl Solution {
    pub fn put_marbles(weights: Vec<i32>, k: i32) -> i64 {
        
        let k = k as usize;
        let mut dp = vec![vec![0; weights.len()]; k];
        let mut sum = vec![0; weights.len()];
        sum[0] = weights[0];
        for i in 1..weights.len() {
            sum[i] = sum[i - 1] + weights[i];
        }
        for i in 0..k {
            for j in i..weights.len() {
                if i == 0 {
                    dp[i][j] = sum[j] as i64;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    for l in i - 1..j {
                        dp[i][j] = std::cmp::min(
                            dp[i][j],
                            dp[i - 1][l] + (sum[j] - sum[l]) as i64,
                        );
                    }
                }
            }
        }
        let max = dp[k - 1][weights.len() - 1];
        let mut min = std::i64::MAX;
        for i in 0..weights.len() {
            let mut sum = 0;
            for j in 0..k {
                let l = if j == 0 {
                    0
                } else {
                    i + j - 1
                };
                if l >= weights.len() {
                    break;
                }
                sum += weights[l];
                if j == k - 1 {
                    min = std::cmp::min(min, sum as i64);
                }
            }
        }
        max - min
    }
}