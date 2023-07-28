impl Solution {
    pub fn count_substrings(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut ans = 0;
        let (m, n) = (s.len(), t.len());
        for i in 0..m {
            for j in 0..n {
                let mut diff = 0;
                let mut k = 0;
                while i+k < m && j+k < n {
                    if s[i+k] != t[j+k] {
                        diff += 1;
                    }
                    if diff == 1 {
                        ans += 1;
                    } else if diff == 2 {
                        break;
                    }
                    k += 1;
                }
            }
        }
        ans
    }
}