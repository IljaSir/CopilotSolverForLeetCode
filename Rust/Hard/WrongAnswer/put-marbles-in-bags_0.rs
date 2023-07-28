impl Solution {
    pub fn put_marbles(weights: Vec<i32>, k: i32) -> i64 {
        
        let n = weights.len();
        let mut prefix = vec![0; n + 1];
        for i in 0..n {
            prefix[i + 1] = prefix[i] + weights[i];
        }
        let mut dp = vec![vec![0; n + 1]; k as usize + 1];
        for i in 0..n + 1 {
            dp[1][i] = prefix[i] as i64;
        }
        for i in 2..k as usize + 1 {
            for j in i..n + 1 {
                let mut minv = std::i64::MAX;
                for p in i - 1..j + 1 {
                    let cost = dp[i - 1][p - 1] + (prefix[j] - prefix[p - 1]) as i64;
                    minv = minv.min(cost);
                }
                dp[i][j] = minv;
            }
        }
        dp[k as usize][n] as i64
    }
}