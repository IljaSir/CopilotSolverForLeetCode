impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            match c {
                'a' => stack.push('a'),
                'b' => {
                    if stack.last() == Some(&'a') {
                        stack.push('b');
                    } else {
                        return false;
                    }
                },
                'c' => {
                    if stack.last() == Some(&'b') {
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