impl Solution {
    pub fn put_marbles(weights: Vec<i32>, k: i32) -> i64 {
        
        let mut dp = vec![vec![0; k as usize + 1]; weights.len() + 1];
        let mut s = vec![0; weights.len() + 1];
        for i in 1..=weights.len() {
            s[i] = s[i - 1] + weights[i - 1];
        }
        for i in 1..=weights.len() {
            for j in 1..=k as usize {
                if i == j {
                    dp[i][j] = s[i] as i64;
                } else {
                    dp[i][j] = i64::max_value();
                    for p in 1..i {
                        dp[i][j] = i64::min(dp[i][j], i64::max(dp[p][j - 1], (s[i] - s[p]) as i64));
                    }
                }
            }
        }
        (s[weights.len()] as i64 - dp[weights.len()][k as usize]) - dp[weights.len()][k as usize]
    }
}