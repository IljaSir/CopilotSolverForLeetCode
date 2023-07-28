impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut ret = String::new();
        let mut depth = 0;
        for c in s.chars() {
            if c == '(' {
                if depth > 0 {
                    ret.push(c);
                }
                depth += 1;
            } else {
                depth -= 1;
                if depth > 0 {
                    ret.push(c);
                }
            }
        }
        ret
    }
}