impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut ret = String::new();
        for c in s.chars() {
            match c {
                '(' => {
                    stack.push(c);
                    if stack.len() > 1 {
                        ret.push(c);
                    }
                }
                ')' => {
                    stack.pop();
                    if !stack.is_empty() {
                        ret.push(c);
                    }
                }
                _ => {}
            }
        }
        ret
    }
}