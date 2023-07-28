impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![std::i32::MAX; n + 1];
        dp[0] = 0;
        for i in 0..=n {
            for j in i.saturating_sub(ranges[i] as usize)..=(i + ranges[i] as usize).min(n) {
                dp[j] = dp[j].min(dp[i] + 1);
            }
        }
        if dp[n] == std::i32::MAX {
            -1
        } else {
            dp[n]
        }
    }
}