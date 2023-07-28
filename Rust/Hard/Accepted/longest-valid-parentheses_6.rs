impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        
        let mut stack: Vec<usize> = vec![0];
        let mut max = 0;
        for (i, c) in s.chars().enumerate() {
            if c == '(' {
                stack.push(i + 1);
            } else {
                stack.pop();
                if stack.is_empty() {
                    stack.push(i + 1);
                } else {
                    max = max.max(i + 1 - stack[stack.len() - 1]);
                }
            }
        }
        max as i32
    }
}