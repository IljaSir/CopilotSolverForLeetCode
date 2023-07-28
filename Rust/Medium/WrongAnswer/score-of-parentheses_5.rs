impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if c == '(' {
                stack.push(0);
            } else {
                let mut cur = 0;
                while let Some(v) = stack.pop() {
                    if v == 0 {
                        stack.push(if cur == 0 { 1 } else { 2 * cur });
                        break;
                    } else {
                        cur += v;
                    }
                }
            }
        }
        stack[0]
    }
}