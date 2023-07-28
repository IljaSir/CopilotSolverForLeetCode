impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut i = 0;
        let mut j = 0;
        while j < s.len() {
            s[i] = s[j];
            i += 1;
            j += 1;
            while j < s.len() && s[j] == s[i - 1] {
                j += 1;
            }
            if j < s.len() && s[j] == s[i - 1] {
                s[i] = s[j];
                i += 1;
                j += 1;
            }
        }
        unsafe { String::from_utf8_unchecked(s[..i].to_vec()) }
    }
}