impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![n; n];
        for i in 0..n {
            let mut l = i;
            let mut r = i;
            while l > 0 && r < n - 1 && s[l - 1] == s[r + 1] {
                dp[l - 1] = dp[l - 1].min(dp[r + 1] + 1);
                l -= 1;
                r += 1;
            }
            l = i;
            r = i + 1;
            while l > 0 && r < n && s[l - 1] == s[r] {
                dp[l - 1] = dp[l - 1].min(dp[r] + 1);
                l -= 1;
                r += 1;
            }
        }
        dp[0] as i32
    }
}