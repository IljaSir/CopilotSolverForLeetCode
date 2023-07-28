impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut stack: Vec<String> = vec![];
        let mut s = s;
        for c in s.chars() {
            if c == '(' {
                stack.push("".to_string());
            } else if c == ')' {
                let mut t = stack.pop().unwrap();
                t = t.chars().rev().collect();
                stack.push(t);
            } else {
                if let Some(t) = stack.last_mut() {
                    t.push(c);
                } else {
                    stack.push(c.to_string());
                }
            }
        }
        stack.join("")
    }
}