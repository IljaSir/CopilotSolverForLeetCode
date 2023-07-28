impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s1 = String::new();
        let mut t1 = String::new();
        for c in s.chars() {
            if c == '#' {
                s1.pop();
            } else {
                s1.push(c);
            }
        }
        for c in t.chars() {
            if c == '#' {
                t1.pop();
            } else {
                t1.push(c);
            }
        }
        s1 == t1
    }
}