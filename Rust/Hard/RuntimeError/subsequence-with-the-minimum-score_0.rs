impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let n = s.len();
        let m = t.len();
        let mut dp = vec![vec![0; m + 1]; n + 1];
        for i in 0..n {
            for j in 0..m {
                if s[i] == t[j] {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j].max(dp[i][j + 1]);
                }
            }
        }
        let lcs = dp[n][m];
        let mut ans = n + m - 2 * lcs;
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut l = 0;
        while i < n && j < m {
            if s[i] == t[j] {
                k = i;
                l = j;
                i += 1;
                j += 1;
            } else {
                if dp[i + 1][j] > dp[i][j + 1] {
                    i += 1;
                } else {
                    j += 1;
                }
            }
        }
        ans = ans.min((l - k + 1).max(lcs));
        i = n - 1;
        j = m - 1;
        k = n - 1;
        l = m - 1;
        while i >= 0 && j >= 0 {
            if s[i] == t[j] {
                k = i;
                l = j;
                i -= 1;
                j -= 1;
            } else {
                if dp[i + 1][j] > dp[i][j + 1] {
                    i -= 1;
                } else {
                    j -= 1;
                }
            }
        }
        ans = ans.min((l - k + 1).max(lcs));
        ans as i32
    }
}