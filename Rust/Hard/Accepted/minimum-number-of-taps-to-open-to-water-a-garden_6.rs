impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![n+1; n+1];
        dp[0] = 0;
        for i in 0..n+1 {
            let l = i.saturating_sub(ranges[i] as usize);
            let r = (i + ranges[i] as usize).min(n);
            for j in l..r+1 {
                dp[j] = dp[j].min(dp[l] + 1);
            }
        }
        if dp[n] == n+1 { -1 } else { dp[n] as i32 }
    }
}