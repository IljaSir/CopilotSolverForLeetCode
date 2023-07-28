impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        
        let mut stack = Vec::new();
        let mut str = String::new();
        for c in s.chars() {
            if c == '(' {
                stack.push(str);
                str = String::new();
            } else if c == ')' {
                str = stack.pop().unwrap() + &str.chars().rev().collect::<String>();
            } else {
                str.push(c);
            }
        }
        str
    }
}