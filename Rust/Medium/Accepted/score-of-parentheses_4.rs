impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if c == '(' {
                stack.push(0);
            } else {
                let mut v = 0;
                while let Some(x) = stack.pop() {
                    if x == 0 {
                        stack.push(if v == 0 { 1 } else { 2 * v });
                        break;
                    } else {
                        v += x;
                    }
                }
            }
        }
        stack.into_iter().sum()
    }
}