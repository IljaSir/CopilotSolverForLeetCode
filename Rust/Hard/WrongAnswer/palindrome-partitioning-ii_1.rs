impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut f = vec![0; n + 1];
        let mut g = vec![vec![false; n]; n];
        for i in 0..n {
            f[i] = i as i32;
            for j in (0..=i).rev() {
                if s[i] == s[j] && (i - j < 2 || g[j + 1][i - 1]) {
                    g[j][i] = true;
                    f[i + 1] = f[i + 1].min(f[j] + 1);
                }
            }
        }
        f[n]
    }
}