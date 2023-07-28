impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = vec![];
        for c in s.chars() {
            match c {
                '(' => stack.push(')'),
                '[' => stack.push(']'),
                '{' => stack.push('}'),
                ')' => {
                    if stack.pop() != Some(')') {
                        return false;
                    }
                }
                ']' => {
                    if stack.pop() != Some(']') {
                        return false;
                    }
                }
                '}' => {
                    if stack.pop() != Some('}') {
                        return false;
                    }
                }
                _ => unreachable!(),
            }
        }
        stack.is_empty()
    }
}