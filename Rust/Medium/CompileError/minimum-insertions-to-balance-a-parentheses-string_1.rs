impl Solution {
    pub fn min_insertions(s: String) -> i32 {
        
        let mut stack = Vec::new();
        let mut ans = 0;
        for c in s.chars() {
            if c == '(' {
                stack.push(c);
            } else {
                if stack.is_empty() {
                    ans += 1;
                } else {
                    stack.pop();
                }
                if c == ')' {
                    if stack.is_empty() {
                        ans += 1;
                    } else {
                        stack.pop();
                        if stack.is_empty() {
                            ans += 1;
                        }
                    }
                }
            }
        }
        ans + stack.len() * 2
    }
}