impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let n = s.len();
        let m = t.len();
        let mut dp = vec![vec![0; m + 1]; 2];
        let mut ans = m;
        for i in 0..n {
            for j in 0..m {
                dp[(i + 1) & 1][j + 1] = if s[i] == t[j] {
                    dp[i & 1][j] + 1
                } else {
                    0
                };
                if dp[(i + 1) & 1][j + 1] > 0 {
                    ans = ans.min(m - j - 1 + i - dp[(i + 1) & 1][j + 1] + 1);
                }
            }
        }
        ans as i32
    }
}