impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut i = 0;
        let mut j = 0;
        let mut min = 100001;
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                let mut k = 0;
                while i + k < s.len() && j + k < t.len() && s[i + k] == t[j + k] {
                    k += 1;
                }
                if k < min {
                    min = k;
                }
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        if min == 100001 {
            return 0;
        }
        (t.len() - min) as i32
    }
}