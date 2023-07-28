impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        let mut f = vec![0; n];
        for i in 0..n {
            f[i] = i as i32;
            for j in 0..=i {
                if s[i] == s[j] && (i - j <= 1 || dp[j + 1][i - 1]) {
                    dp[j][i] = true;
                    if j == 0 {
                        f[i] = 0;
                    } else {
                        f[i] = f[i].min(f[j - 1] + 1);
                    }
                }
            }
        }
        f[n - 1]
    }
}