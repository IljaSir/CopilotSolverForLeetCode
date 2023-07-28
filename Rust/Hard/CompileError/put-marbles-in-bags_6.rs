impl Solution {
    pub fn put_marbles(weights: Vec<i32>, k: i32) -> i64 {
        
        let sz = weights.len();
        let mut sum = vec![0; sz+1];
        for i in 0..sz {
            sum[i+1] = sum[i] + weights[i];
        }
        let mut dp = vec![vec![0; sz+1]; k as usize];
        for i in 0..sz {
            dp[0][i+1] = sum[i+1];
        }
        for i in 1..k as usize {
            for j in i..sz {
                let mut min = i64::max_value();
                for l in i-1..j {
                    let s = dp[i-1][l+1] + (sum[j+1] - sum[l+1]) * (sum[j+1] - sum[l+1]);
                    if s < min {
                        min = s;
                    }
                }
                dp[i][j+1] = min;
            }
        }
        dp[k as usize - 1][sz] as i64
    }
}