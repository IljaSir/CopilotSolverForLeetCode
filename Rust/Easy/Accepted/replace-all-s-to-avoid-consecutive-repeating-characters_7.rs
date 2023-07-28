impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut i = 0;
        while i < s.len() {
            if s[i] == b'?' {
                let mut c = b'a';
                while (i > 0 && s[i - 1] == c) || (i + 1 < s.len() && s[i + 1] == c) {
                    c += 1;
                }
                s[i] = c;
            }
            i += 1;
        }
        String::from_utf8(s).unwrap()
    }
}