impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut result = String::new();
        let mut stack = vec![];
        for c in s.chars() {
            if c == '(' {
                if !stack.is_empty() {
                    result.push(c);
                }
                stack.push(c);
            } else if c == ')' {
                if stack.len() > 1 {
                    result.push(c);
                }
                stack.pop();
            }
        }
        result
    }
}