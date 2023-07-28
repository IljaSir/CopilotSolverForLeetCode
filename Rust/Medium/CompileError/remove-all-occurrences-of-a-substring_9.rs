impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s;
        let mut part = part;
        let mut i = s.find(&part);
        while i.is_some() {
            let i = i.unwrap();
            s.replace_range(i..i+part.len(), "");
            i = s.find(&part);
        }
        s
    }
}