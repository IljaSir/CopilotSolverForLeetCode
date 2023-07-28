impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if c == '[' {
                stack.push(c);
            } else {
                if stack.is_empty() {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }
        let mut left = 0;
        let mut right = 0;
        for c in stack {
            if c == '[' {
                left += 1;
            } else {
                right += 1;
            }
        }
        (left + 1) / 2 + (right + 1) / 2
    }
}