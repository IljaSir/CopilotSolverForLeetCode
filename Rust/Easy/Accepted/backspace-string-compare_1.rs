impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        
        let mut s_stack = Vec::new();
        let mut t_stack = Vec::new();
        for c in s.chars() {
            if c == '#' {
                s_stack.pop();
            } else {
                s_stack.push(c);
            }
        }
        for c in t.chars() {
            if c == '#' {
                t_stack.pop();
            } else {
                t_stack.push(c);
            }
        }
        s_stack == t_stack
    }
}