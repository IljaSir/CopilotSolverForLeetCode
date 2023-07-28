impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
        
        let mut stack = Vec::new();
        for c in s.chars() {
            if c == '(' {
                stack.push(0);
            } else {
                let mut sum = 0;
                while let Some(v) = stack.pop() {
                    if v == 0 {
                        stack.push(if sum == 0 { 1 } else { 2 * sum });
                        break;
                    } else {
                        sum += v;
                    }
                }
            }
        }
        stack.iter().sum()
    }
}