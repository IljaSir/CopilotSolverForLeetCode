impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s;
        while s.contains(&part) {
            s = s.replace(&part, "");
        }
        s
    }
}