impl Solution {
    pub fn remove_stars(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut i = 0;
        let mut j = 0;
        while j < s.len() {
            if s[i] == b'*' {
                i -= 1;
                while i >= 0 && s[i] == b'*' {
                    i -= 1;
                }
                if i < 0 {
                    i = j;
                }
            } else {
                i += 1;
                if i == j {
                    j += 1;
                }
            }
        }
        unsafe { String::from_utf8_unchecked(s[..i].to_vec()) }
    }
}