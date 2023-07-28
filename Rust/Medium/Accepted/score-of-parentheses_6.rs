impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
        
        let mut stack = vec![];
        for c in s.chars() {
            if c == '(' {
                stack.push(0);
            } else {
                let mut n = 0;
                while let Some(x) = stack.pop() {
                    if x == 0 {
                        stack.push(if n == 0 { 1 } else { 2 * n });
                        break;
                    } else {
                        n += x;
                    }
                }
            }
        }
        stack.iter().sum()
    }
}