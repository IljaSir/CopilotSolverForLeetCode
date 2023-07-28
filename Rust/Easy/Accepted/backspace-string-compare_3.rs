impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s1 = String::new();
        let mut s2 = String::new();
        for c in s.chars() {
            if c == '#' {
                s1.pop();
            } else {
                s1.push(c);
            }
        }
        for c in t.chars() {
            if c == '#' {
                s2.pop();
            } else {
                s2.push(c);
            }
        }
        s1 == s2
    }
}