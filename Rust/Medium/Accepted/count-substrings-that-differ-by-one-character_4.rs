impl Solution {
    pub fn count_substrings(s: String, t: String) -> i32 {
        
        let s = s.into_bytes();
        let t = t.into_bytes();
        let n = s.len();
        let m = t.len();
        let mut ans = 0;
        for i in 0..n {
            for j in 0..m {
                let mut diff = 0;
                let mut k = 0;
                while i + k < n && j + k < m {
                    if s[i + k] != t[j + k] {
                        diff += 1;
                    }
                    if diff > 1 {
                        break;
                    }
                    k += 1;
                    if diff == 1 {
                        ans += 1;
                    }
                }
            }
        }
        ans
    }
}