impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut stack = vec![];
        let mut result = String::new();
        for c in s.chars() {
            if c == '(' {
                stack.push(result);
                result = String::new();
            } else if c == ')' {
                let mut reversed = String::new();
                for c in result.chars() {
                    reversed.insert(0, c);
                }
                result = stack.pop().unwrap() + &reversed;
            } else {
                result.push(c);
            }
        }
        result
    }
}