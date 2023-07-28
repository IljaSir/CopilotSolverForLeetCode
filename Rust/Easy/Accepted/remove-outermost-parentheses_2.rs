impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut stack = vec![];
        let mut res = String::new();
        for c in s.chars() {
            if c == '(' {
                if !stack.is_empty() {
                    res.push(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                if !stack.is_empty() {
                    res.push(c);
                }
            }
        }
        res
    }
}