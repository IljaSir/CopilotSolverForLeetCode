impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut result = 0;
        let mut stack: Vec<char> = Vec::new();
        for c in s.chars() {
            match c {
                '(' => {
                    stack.push(c);
                }
                ')' => {
                    if stack.len() > 0 {
                        stack.pop();
                    } else {
                        result += 1;
                    }
                    if stack.len() > 0 {
                        stack.pop();
                    } else {
                        result += 1;
                    }
                    if stack.len() > 0 && stack[stack.len() - 1] == '(' {
                        stack.pop();
                        result += 1;
                    }
                }
                _ => {
                    panic!("invalid input");
                }
            }
        }
        result += stack.len() * 2;
        result
    }
}