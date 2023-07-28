impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut t = vec![];
        let mut res = vec![];
        while !s.is_empty() || !t.is_empty() {
            if t.is_empty() || (!s.is_empty() && s[0] <= t[t.len() - 1]) {
                t.push(s.remove(0));
            } else {
                res.push(t.pop().unwrap());
            }
        }
        res.extend(t.iter().rev());
        String::from_utf8(res).unwrap()
    }
}