impl Solution {
    pub fn count_substrings(s: String, t: String) -> i32 {
        
        let (s, t) = (s.into_bytes(), t.into_bytes());
        let (n, m) = (s.len(), t.len());
        let mut ans = 0;
        for i in 0..n {
            for j in 0..m {
                let mut diff = 0;
                for k in 0..(n.min(m) - i.min(j)) {
                    if s[i + k] != t[j + k] {
                        diff += 1;
                    }
                    if diff == 1 {
                        ans += 1;
                    } else if diff > 1 {
                        break;
                    }
                }
            }
        }
        ans
    }
}