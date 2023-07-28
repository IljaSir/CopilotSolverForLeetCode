impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s;
        while let Some(index) = s.find(&part) {
            s.replace_range(index..index + part.len(), "");
        }
        s
    }
}