impl Solution {
    pub fn modify_string(s: String) -> String {
        
        let mut s = s.as_bytes().to_vec();
        let mut i = 0;
        while i < s.len() {
            if s[i] == b'?' {
                s[i] = b'a';
                if i > 0 && s[i] == s[i - 1] {
                    s[i] += 1;
                }
                if i + 1 < s.len() && s[i] == s[i + 1] {
                    s[i] += 1;
                }
            }
            i += 1;
        }
        String::from_utf8(s).unwrap()
    }
}