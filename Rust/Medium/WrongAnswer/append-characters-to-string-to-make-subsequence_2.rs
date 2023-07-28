impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        while i < s.len() {
            if j < t.len() && s[i] == t[j] {
                j += 1;
            }
            i += 1;
            res += 1;
        }
        res - j as i32
    }
}