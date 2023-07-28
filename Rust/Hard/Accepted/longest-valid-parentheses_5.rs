impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        
        let mut stack = vec![-1];
        let mut max_len = 0;
        for (i, c) in s.chars().enumerate() {
            let i = i as i32;
            if c == '(' {
                stack.push(i);
            } else {
                stack.pop();
                if let Some(&j) = stack.last() {
                    max_len = max_len.max(i - j);
                } else {
                    stack.push(i);
                }
            }
        }
        max_len
    }
}