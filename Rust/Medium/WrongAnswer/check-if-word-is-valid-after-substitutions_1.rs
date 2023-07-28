impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            match c {
                'a' => stack.push('a'),
                'b' => {
                    if let Some('a') = stack.last() {
                        stack.pop();
                        stack.push('b');
                    } else {
                        return false;
                    }
                },
                'c' => {
                    if let Some('b') = stack.last() {
                        stack.pop();
                        stack.pop();
                    } else {
                        return false;
                    }
                },
                _ => return false,
            }
        }
        stack.is_empty()
    }
}