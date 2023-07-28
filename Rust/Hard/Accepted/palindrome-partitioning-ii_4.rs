impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        let mut f = vec![0; n + 1];
        for i in (0..n).rev() {
            f[i] = n;
            for j in i..n {
                if s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    f[i] = f[i].min(f[j + 1] + 1);
                }
            }
        }
        f[0] as i32 - 1
    }
}