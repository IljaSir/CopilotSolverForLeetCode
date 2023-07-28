impl Solution {
    pub fn is_scramble(s1: String, s2: String) -> bool {
        
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let n = s1.len();
        let mut f = vec![vec![vec![false; n + 1]; n]; n];
        for i in 0..n {
            for j in 0..n {
                f[i][j][1] = s1[i] == s2[j];
            }
        }
        for l in 2..=n {
            for i in 0..=n - l {
                for j in 0..=n - l {
                    for k in 1..l {
                        if (f[i][j][k] && f[i + k][j + k][l - k]) || (f[i][j + l - k][k] && f[i + k][j][l - k]) {
                            f[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        f[0][0][n]
    }
}