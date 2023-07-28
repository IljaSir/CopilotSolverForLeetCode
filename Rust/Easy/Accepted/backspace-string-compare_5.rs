impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s1 = Vec::new();
        let mut s2 = Vec::new();
        for c in s.chars() {
            if c == '#' {
                if !s1.is_empty() {
                    s1.pop();
                }
            } else {
                s1.push(c);
            }
        }
        for c in t.chars() {
            if c == '#' {
                if !s2.is_empty() {
                    s2.pop();
                }
            } else {
                s2.push(c);
            }
        }
        s1 == s2
    }
}