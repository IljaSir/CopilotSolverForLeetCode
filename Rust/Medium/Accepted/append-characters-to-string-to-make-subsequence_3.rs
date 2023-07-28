impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        let s = s.as_bytes();
        let t = t.as_bytes();
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        if j < t.len() {
            count = t.len() - j;
        }
        count as i32
    }
}