impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut t = Vec::new();
        let mut res = Vec::new();
        while !s.is_empty() || !t.is_empty() {
            if s.is_empty() {
                res.push(t.pop().unwrap());
            } else if t.is_empty() {
                t.push(s.remove(0));
            } else if s[0] < t[t.len()-1] {
                t.push(s.remove(0));
            } else {
                res.push(t.pop().unwrap());
            }
        }
        String::from_utf8(res).unwrap()
    }
}