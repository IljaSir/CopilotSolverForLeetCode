impl Solution {
    pub fn num_distinct(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let n = s.len();
        let m = t.len();
        let mut f = vec![vec![0; m + 1]; n + 1];
        for i in 0..=n {
            f[i][0] = 1;
        }
        for i in 1..=n {
            for j in 1..=m {
                f[i][j] = f[i - 1][j];
                if s[i - 1] == t[j - 1] {
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        f[n][m]
    }
}