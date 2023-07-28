impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s;
        let part = part.as_bytes();
        let mut i = 0;
        while i + part.len() <= s.len() {
            let mut j = 0;
            while j < part.len() && s.as_bytes()[i + j] == part[j] {
                j += 1;
            }
            if j == part.len() {
                s = format!("{}{}", &s[..i], &s[i + j..]);
                i = 0;
            } else {
                i += 1;
            }
        }
        s
    }
}