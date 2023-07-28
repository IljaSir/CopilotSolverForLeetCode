impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut f = vec![n; n];
        let mut g = vec![vec![false; n]; n];
        for i in (0..n).rev() {
            for j in i..n {
                if s[i] == s[j] && (j - i < 2 || g[i + 1][j - 1]) {
                    g[i][j] = true;
                }
            }
        }
        for i in 0..n {
            if g[0][i] {
                f[i] = 0;
            } else {
                for j in 0..i {
                    if g[j + 1][i] {
                        f[i] = f[i].min(f[j] + 1);
                    }
                }
            }
        }
        f[n - 1] as i32
    }
}