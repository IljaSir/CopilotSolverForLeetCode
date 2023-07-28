impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        for i in 0..ranges.len() {
            let left = i as i32 - ranges[i];
            let right = i as i32 + ranges[i];
            if left >= 0 {
                dp[left as usize] = dp[left as usize].max(right);
            }
            if right >= 0 {
                dp[right as usize] = dp[right as usize].max(right);
            }
        }
        let mut res = 0;
        let mut cur = 0;
        let mut next = 0;
        for i in 0..dp.len() {
            if cur < i as i32 {
                return -1;
            }
            next = next.max(dp[i]);
            if next == i as i32 {
                return -1;
            }
            if cur == i as i32 {
                res += 1;
                cur = next;
            }
        }
        res
    }
}