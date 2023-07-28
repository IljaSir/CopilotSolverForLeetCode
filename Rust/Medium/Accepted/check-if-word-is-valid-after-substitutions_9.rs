impl Solution {
    pub fn is_valid(s: String) -> bool {
        
        let mut stack = vec![];
        for c in s.chars() {
            match c {
                'a' => {
                    stack.push('a');
                },
                'b' => {
                    if stack.len() > 0 && stack[stack.len() - 1] == 'a' {
                        stack.push('b');
                    } else {
                        return false;
                    }
                },
                'c' => {
                    if stack.len() > 1 && stack[stack.len() - 1] == 'b' && stack[stack.len() - 2] == 'a' {
                        stack.pop();
                        stack.pop();
                    } else {
                        return false;
                    }
                },
                _ => {
                    return false;
                }
            }
        }
        stack.len() == 0
    }
}