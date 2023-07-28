impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if c == ')' {
                if stack.is_empty() {
                    stack.push(c);
                } else {
                    if *stack.last().unwrap() == '(' {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            } else {
                stack.push(c);
            }
        }
        stack.len() as i32
    }
}