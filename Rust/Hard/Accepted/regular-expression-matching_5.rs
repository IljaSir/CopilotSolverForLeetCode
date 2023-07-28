impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        
        let (s, p) = (s.into_bytes(), p.into_bytes());
        let (n, m) = (s.len(), p.len());
        let mut f = vec![vec![false; m + 1]; n + 1];
        f[0][0] = true;
        for i in 0..=n {
            for j in 1..=m {
                if p[j - 1] == b'*' {
                    f[i][j] |= f[i][j - 2];
                    if i > 0 && (s[i - 1] == p[j - 2] || p[j - 2] == b'.') {
                        f[i][j] |= f[i - 1][j];
                    }
                } else {
                    if i > 0 && (s[i - 1] == p[j - 1] || p[j - 1] == b'.') {
                        f[i][j] |= f[i - 1][j - 1];
                    }
                }
            }
        }
        f[n][m]
    }
}