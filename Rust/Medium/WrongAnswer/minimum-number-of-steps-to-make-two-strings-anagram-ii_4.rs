impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut s = s.into_bytes();
        let mut t = t.into_bytes();
        s.sort();
        t.sort();
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while i < s.len() {
            if j >= t.len() {
                count += 1;
                i += 1;
                continue;
            }
            if s[i] == t[j] {
                i += 1;
                j += 1;
                continue;
            }
            if s[i] < t[j] {
                i += 1;
                count += 1;
                continue;
            }
            if s[i] > t[j] {
                j += 1;
            }
        }
        count += t.len() - j;
        count as i32
    }
}