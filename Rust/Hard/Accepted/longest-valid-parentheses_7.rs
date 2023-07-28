impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        
        let mut max = 0;
        let mut stack = vec![];
        let mut start = 0;
        for (i, c) in s.chars().enumerate() {
            if c == '(' {
                stack.push(i);
            } else {
                if stack.is_empty() {
                    start = i + 1;
                } else {
                    stack.pop();
                    let tmp = if stack.is_empty() {
                        i - start + 1
                    } else {
                        i - stack.last().unwrap()
                    };
                    max = max.max(tmp);
                }
            }
        }
        max as i32
    }
}