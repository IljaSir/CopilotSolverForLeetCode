impl Solution {
    pub fn append_characters(s: String, t: String) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        let s = s.as_bytes();
        let t = t.as_bytes();
        while j < t.len() {
            if i < s.len() && s[i] == t[j] {
                i += 1;
                j += 1;
            } else {
                res += 1;
                i += 1;
            }
        }
        res
    }
}