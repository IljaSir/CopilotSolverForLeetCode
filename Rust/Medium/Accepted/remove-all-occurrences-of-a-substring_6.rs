impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s;
        let mut part = part;
        while let Some(pos) = s.find(&part) {
            s = format!("{}{}", &s[..pos], &s[pos+part.len()..]);
        }
        s
    }
}