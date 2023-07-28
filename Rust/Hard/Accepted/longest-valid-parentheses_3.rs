impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        
        let mut res = 0;
        let mut stack = vec![-1];
        for (i, c) in s.chars().enumerate() {
            if c == '(' {
                stack.push(i as i32);
            } else {
                stack.pop();
                if stack.is_empty() {
                    stack.push(i as i32);
                } else {
                    res = res.max(i as i32 - stack[stack.len() - 1]);
                }
            }
        }
        res
    }
}