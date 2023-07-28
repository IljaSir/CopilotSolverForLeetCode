impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            dp[i][i] = true;
        }
        for i in 0..n - 1 {
            dp[i][i + 1] = s[i] == s[i + 1];
        }
        for len in 3..=n {
            for i in 0..n - len + 1 {
                dp[i][i + len - 1] = dp[i + 1][i + len - 2] && s[i] == s[i + len - 1];
            }
        }
        let mut f = vec![0; n + 1];
        for i in 1..=n {
            f[i] = i - 1;
            for j in 0..i {
                if dp[j][i - 1] {
                    f[i] = f[i].min(f[j] + 1);
                }
            }
        }
        f[n] as i32
    }
}