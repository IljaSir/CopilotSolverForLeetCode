impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            match c {
                '(' | '[' | '{' => stack.push(c),
                ')' | ']' | '}' => {
                    let last = stack.pop().unwrap_or(' ');
                    if !((c == ')' && last == '(') || (c == ']' && last == '[') || (c == '}' && last == '{')) {
                        return false;
                    }
                },
                _ => return false,
            }
        }
        stack.is_empty()
    }
}