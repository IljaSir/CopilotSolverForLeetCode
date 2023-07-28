impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let mut dp = vec![-1; n as usize + 1];
        dp[0] = 0;
        for i in 0..n + 1 {
            let left = (i - ranges[i as usize]).max(0) as usize;
            let right = (i + ranges[i as usize]).min(n) as usize;
            for j in left..right + 1 {
                if dp[j] == -1 || dp[j] > dp[left] + 1 {
                    dp[j] = dp[left] + 1;
                }
            }
        }
        dp[n as usize]
    }
}