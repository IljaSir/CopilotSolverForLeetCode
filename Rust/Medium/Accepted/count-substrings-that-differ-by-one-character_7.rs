impl Solution {
    pub fn count_substrings(s: String, t: String) -> i32 {
        
        let (s, t) = (s.into_bytes(), t.into_bytes());
        let (mut ans, n, m) = (0, s.len(), t.len());
        for i in 0..n {
            for j in 0..m {
                let mut diff = 0;
                for k in 0..(n - i).min(m - j) {
                    if s[i + k] != t[j + k] {
                        diff += 1;
                    }
                    if diff == 2 {
                        break;
                    }
                    if diff == 1 {
                        ans += 1;
                    }
                }
            }
        }
        ans
    }
}