impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            match c {
                '(' | '[' | '{' => stack.push(c),
                ')' | ']' | '}' => {
                    if let Some(d) = stack.pop() {
                        if (d == '(' && c != ')') || (d == '[' && c != ']') || (d == '{' && c != '}') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                _ => return false,
            }
        }
        stack.is_empty()
    }
}