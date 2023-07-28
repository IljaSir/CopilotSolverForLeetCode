impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack: Vec<char> = vec![];
        for c in s.chars() {
            if c == '(' || c == '[' || c == '{' {
                stack.push(c);
            } else if c == ')' {
                if let Some(x) = stack.pop() {
                    if x != '(' {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if c == ']' {
                if let Some(x) = stack.pop() {
                    if x != '[' {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if c == '}' {
                if let Some(x) = stack.pop() {
                    if x != '{' {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        stack.is_empty()
    }
}