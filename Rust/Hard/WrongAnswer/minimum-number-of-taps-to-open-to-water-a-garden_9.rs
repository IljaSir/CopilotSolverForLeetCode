impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        for i in 0..n + 1 {
            let left = if i - ranges[i as usize] < 0 { 0 } else { i - ranges[i as usize] };
            let right = i + ranges[i as usize];
            dp[left as usize] = dp[left as usize].max(right);
        }
        let mut end = 0;
        let mut far = 0;
        let mut ans = 0;
        for i in 0..n + 1 {
            far = far.max(dp[i as usize]);
            if i == end {
                ans += 1;
                end = far;
            }
        }
        if end < n { -1 } else { ans }
    }
}