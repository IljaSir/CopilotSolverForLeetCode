impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = vec![];
        for c in s.chars() {
            if c == 'c' {
                if stack.len() < 2 || stack.pop() != Some('b') || stack.pop() != Some('a') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        stack.is_empty()
    }
}