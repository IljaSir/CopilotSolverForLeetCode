impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            match c {
                'a' => stack.push(c),
                'b' => {
                    if stack.last() == Some(&'a') {
                        stack.push(c);
                    } else {
                        return false;
                    }
                }
                'c' => {
                    if stack.len() >= 2 && stack[stack.len() - 2] == 'a' {
                        stack.pop();
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                _ => unreachable!(),
            }
        }
        stack.is_empty()
    }
}