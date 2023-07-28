impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![n+1; n+1];
        dp[0] = 0;
        for i in 0..n+1 {
            let left = i.saturating_sub(ranges[i] as usize);
            let right = (i + ranges[i] as usize).min(n);
            for j in left..right+1 {
                dp[j] = dp[j].min(dp[left] + 1);
            }
        }
        if dp[n] == n+1 {
            return -1;
        }
        dp[n]
    }
}