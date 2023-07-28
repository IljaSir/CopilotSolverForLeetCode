impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if c == 'c' {
                if stack.len() < 2 {
                    return false;
                }
                if stack.pop().unwrap() != 'b' {
                    return false;
                }
                if stack.pop().unwrap() != 'a' {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        stack.is_empty()
    }
}