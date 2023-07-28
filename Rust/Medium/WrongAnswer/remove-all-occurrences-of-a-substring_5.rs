impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s;
        let part = part;
        loop {
            let new_s = s.replace(&part, "");
            if new_s == s {
                break;
            }
            s = new_s;
        }
        s
    }
}