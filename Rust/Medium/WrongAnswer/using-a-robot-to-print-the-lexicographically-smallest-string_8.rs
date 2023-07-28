impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut t = Vec::new();
        let mut result = String::new();
        while !s.is_empty() || !t.is_empty() {
            if s.is_empty() || (!t.is_empty() && t[t.len() - 1] < s[0]) {
                result.push(t.pop().unwrap() as char);
            } else if t.is_empty() || (!s.is_empty() && s[0] <= t[t.len() - 1]) {
                t.push(s.remove(0));
            }
        }
        result
    }
}