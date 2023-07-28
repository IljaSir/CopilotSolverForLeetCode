impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        
        let mut stack = Vec::new();
        let mut result = 0;
        for c in s.chars() {
            if c == '(' {
                stack.push(c);
            } else {
                if stack.len() == 0 {
                    result += 1;
                } else {
                    stack.pop();
                }
            }
        }
        result += stack.len() as i32;
        result
    }
}