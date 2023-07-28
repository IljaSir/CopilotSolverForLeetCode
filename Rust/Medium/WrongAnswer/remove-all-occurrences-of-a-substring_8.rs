impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s;
        let mut part = part;
        let mut i = 0;
        while i < s.len() {
            if s[i..].starts_with(&part) {
                s.replace_range(i..i+part.len(), "");
            } else {
                i += 1;
            }
        }
        s
    }
}