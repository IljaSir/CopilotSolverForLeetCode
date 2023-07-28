impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![n + 2; n + 1];
        dp[0] = 0;
        for i in 0..n + 1 {
            let l = if i as i32 - ranges[i] < 0 {
                0
            } else {
                i - ranges[i] as usize
            };
            let r = if i as i32 + ranges[i] > n as i32 {
                n
            } else {
                i + ranges[i] as usize
            };
            for j in l..r + 1 {
                dp[j] = dp[j].min(dp[l] + 1);
            }
        }
        if dp[n] >= n + 2 {
            -1
        } else {
            dp[n]
        }
    }
}