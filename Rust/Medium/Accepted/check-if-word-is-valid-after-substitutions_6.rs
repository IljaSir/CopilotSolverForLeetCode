impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack: Vec<char> = Vec::new();
        for c in s.chars() {
            if c == 'c' {
                if let (Some(b), Some(a)) = (stack.pop(), stack.pop()) {
                    if !(a == 'a' && b == 'b') {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        stack.is_empty()
    }
}