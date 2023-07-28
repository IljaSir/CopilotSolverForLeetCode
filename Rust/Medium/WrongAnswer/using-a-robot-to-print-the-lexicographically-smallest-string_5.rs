impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut t = vec![];
        let mut p = vec![];
        while !s.is_empty() || !t.is_empty() {
            if t.is_empty() {
                p.push(s.remove(0));
            } else if s.is_empty() {
                p.push(t.pop().unwrap());
            } else {
                if s[0] < t[t.len() - 1] {
                    p.push(s.remove(0));
                } else {
                    p.push(t.pop().unwrap());
                }
            }
        }
        p.iter().collect()
    }
}