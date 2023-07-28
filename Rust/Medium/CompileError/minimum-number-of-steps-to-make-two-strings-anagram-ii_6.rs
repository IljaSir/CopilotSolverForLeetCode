impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut s = s.as_bytes().to_vec();
        let mut t = t.as_bytes().to_vec();
        s.sort();
        t.sort();
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < t.len() {
            if s[i] < t[j] {
                i += 1;
                count += 1;
            } else if s[i] > t[j] {
                j += 1;
                count += 1;
            } else {
                i += 1;
                j += 1;
            }
        }
        count + s.len() - i + t.len() - j
    }
}