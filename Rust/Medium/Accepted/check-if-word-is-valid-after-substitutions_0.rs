impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            match c {
                'c' => {
                    if stack.pop() != Some('b') {
                        return false;
                    }
                    if stack.pop() != Some('a') {
                        return false;
                    }
                }
                _ => {
                    stack.push(c);
                }
            }
        }
        stack.len() == 0
    }
}