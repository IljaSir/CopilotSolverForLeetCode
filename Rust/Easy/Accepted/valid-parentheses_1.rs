impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            match c {
                '(' => stack.push(')'),
                '[' => stack.push(']'),
                '{' => stack.push('}'),
                ')' | ']' | '}' => {
                    if stack.is_empty() || stack.pop().unwrap() != c {
                        return false;
                    }
                }
                _ => unreachable!(),
            }
        }
        stack.is_empty()
    }
}