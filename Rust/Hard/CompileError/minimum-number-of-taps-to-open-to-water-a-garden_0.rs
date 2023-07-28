impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut dp = vec![n + 2; n + 1];
        dp[0] = 0;
        for i in 0..=n {
            let l = if i >= ranges[i] as usize { i - ranges[i] as usize } else { 0 };
            let r = if i + ranges[i] as usize <= n { i + ranges[i] as usize } else { n };
            for j in l..=r {
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