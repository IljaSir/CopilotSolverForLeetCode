impl Solution {
    pub fn put_marbles(weights: Vec<i32>, k: i32) -> i64 {
        
        let mut sum = 0;
        for i in 0..weights.len() {
            sum += weights[i] as i64;
        }
        let mut dp = vec![vec![sum; weights.len()]; k as usize];
        for i in 0..weights.len() {
            dp[0][i] = weights[i] as i64;
        }
        for i in 1..k as usize {
            for j in 0..weights.len() {
                let mut min = std::i64::MAX;
                let mut sum = 0;
                for l in (i..=j).rev() {
                    sum += weights[l] as i64;
                    let cost = sum + dp[i - 1][l - 1];
                    min = std::cmp::min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        (sum - dp[k as usize - 1][weights.len() - 1]) as i64
    }
}