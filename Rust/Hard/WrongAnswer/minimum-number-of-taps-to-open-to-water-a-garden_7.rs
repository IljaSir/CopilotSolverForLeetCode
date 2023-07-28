impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let mut dp = vec![std::i32::MAX; (n + 1) as usize];
        dp[0] = 0;
        for i in 0..=n {
            let left = i - ranges[i as usize];
            let right = i + ranges[i as usize];
            let left = left.max(0);
            let right = right.min(n);
            for j in left..=right {
                dp[j as usize] = dp[j as usize].min(dp[left as usize] + 1);
            }
        }
        if dp[n as usize] == std::i32::MAX {
            -1
        } else {
            dp[n as usize]
        }
    }
}