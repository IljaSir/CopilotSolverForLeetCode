impl Solution {
    pub fn min_taps(n: i32, ranges: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; n as usize + 1];
        for i in 0..n as usize + 1 {
            let l = i as i32 - ranges[i];
            let r = i as i32 + ranges[i];
            let l = l.max(0);
            let r = r.min(n);
            dp[l as usize] = dp[l as usize].max(r - l);
        }
        let mut maxr = 0;
        let mut ans = 0;
        let mut pre = 0;
        for i in 0..n as usize + 1 {
            if i > maxr {
                return -1;
            }
            maxr = maxr.max(i as i32 + dp[i]);
            if i as i32 == maxr {
                return ans + 1;
            }
            if i as i32 == pre + dp[pre as usize] {
                ans += 1;
                pre = i as i32;
            }
        }
        ans
    }
}